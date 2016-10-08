package com.lanniuh.mq;

import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;
import com.lanniuh.util.StringUtil;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by linjian
 * 16/8/18.
 */
public class ConnectFactory {
    private static Logger logger = Logger.getLogger(ConnectFactory.class);
    // get方法key的后缀
    private final static String GET_KEY_END = "_1";
    // put方法key的后缀
    private final static String PUT_KEY_END = "_0";
    // 超时的后缀
    private final static String TIMEOUT_KEY_END = "_timeout";
    private static String configPath = "mqConfig/";
    private static String configFile = "ESBMQClientProperty.properties";


    private MQQueueManager mqQueueManager;
    private static ConcurrentHashMap<String, String> mqConfigMap = new ConcurrentHashMap<String, String>();
    private static final ConnectFactory CONNECT_FACTORY = new ConnectFactory();

    public static ConnectFactory getInstance() {
        return CONNECT_FACTORY;
    }

    private ConnectFactory() {
//        ResourceBundle bundle = null;
        Properties properties = null;
        try {
            InputStream is = null;
            is = getDefaultClassLoader().getResourceAsStream(configPath+configFile);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            properties = new Properties();
            properties.load(bf);
            logger.debug("加载配置文件成功");
        } catch (Exception e) {
            logger.debug("加载配置文件失败");
            e.printStackTrace();
        }
        Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Object, Object> entry = it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            mqConfigMap.put(key, value);
            logger.debug("加载配置: " + key + "=" + value);
        }
    }

    private static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable localThrowable) {
        }
        if (cl == null)
        {
            cl = ConnectFactory.class.getClassLoader();
            if (cl == null)
            {
                try
                {
                    cl = ClassLoader.getSystemClassLoader();
                }
                catch (Throwable localThrowable1)
                {
                }
            }
        }
        return cl;
    }

    /**
     * @param qmr 队列管理器实例
     * @param fid 服务Id
     * @param msg 消息内容
     * @return
     * @throws IOException
     * @throws MQException
     */
    public String putMsg(MQQueueManager qmr, String fid, String msg) throws IOException, MQException {
        if (msg == null) {
            return null;
        }
        String putQName = mqConfigMap.get(fid + PUT_KEY_END);

        // 设置连接队列的属性
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;
        MQQueue queue = null;
        String msgId = null;
        try {
            // 创建队列实例
            queue = qmr.accessQueue(putQName, openOptions);
            // 创建消息对象
            MQMessage message = new MQMessage();
            //设置消息队列参数
            MQPutMessageOptions putMsgOpt = new MQPutMessageOptions();
            putMsgOpt.options = MQConstants.MQPMO_FAIL_IF_QUIESCING | MQConstants.MQPMO_NEW_MSG_ID;
            // 设置消息的内容
            message.characterSet = Integer.parseInt(mqConfigMap.get("messageCharacterSet"));
            message.format = MQConstants.MQFMT_STRING;
            message.writeString(msg);
            // 发送消息到队列
            queue.put(message, putMsgOpt);
            // 获取messageId
            msgId = StringUtil.bytes2String(message.messageId);
        } finally {
            try {
                if (queue != null)
                    queue.close();
            } catch (MQException e) {
                e.printStackTrace();
            }
        }
        return msgId;

    }

    public String getMsgById(MQQueueManager qmr, String fid, String msgId) throws MQException, IOException {
        // 根据fid获取队列名称
        String qName = mqConfigMap.get(fid + GET_KEY_END);
        // 设置连接队列的属性
        int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_FAIL_IF_QUIESCING;
        // 队列实例
        MQQueue queue = null;
        String msg = null;
        try {
            // 创建队列实例
            queue = qmr.accessQueue(qName, openOptions);

            // 创建消息对象
            MQMessage message = new MQMessage();
            // 设置消息选项
            MQGetMessageOptions getMsgOpt = new MQGetMessageOptions();
            getMsgOpt.options = getMsgOpt.options | MQConstants.MQGMO_FAIL_IF_QUIESCING
                    | MQConstants.MQGMO_WAIT;

            // 设置correlationId
            message.messageId = MQConstants.MQMI_NONE;
            message.correlationId = StringUtil.string2Bytes(msgId);
            getMsgOpt.matchOptions = MQConstants.MQMO_MATCH_CORREL_ID;

            // 设置超时,将等待时间转化成毫秒
            int waitInterval = Integer.parseInt(mqConfigMap.get(fid + TIMEOUT_KEY_END)) * 1000;
            getMsgOpt.waitInterval = waitInterval;

            // 获取消息，成功获取消息后，队列中该条消息将自动删除
            queue.get(message, getMsgOpt);
            // 读取消息内容
            message.format = MQConstants.MQFMT_STRING;
            msg = message.readStringOfByteLength(message.getMessageLength());
        } finally {
            try {
                // 关闭队列
                if (queue != null) {
                    queue.close();
                }
            } catch (MQException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }


    /**
     * 连接队列管理器
     *
     * @return
     * @throws MQException
     */
    public MQQueueManager connectMQ() throws MQException {
        MQEnvironment.hostname = mqConfigMap.get("hostName");
        MQEnvironment.channel = mqConfigMap.get("channel");
        MQEnvironment.CCSID = Integer.parseInt(mqConfigMap.get("ccsid"));
        MQEnvironment.port = Integer.parseInt(mqConfigMap.get("hostPort"));
        String queueManagerName = mqConfigMap.get("queueManagerName");
        // 定义并初始化队列管理器对象并连接
        // MQQueueManager可以被多线程共享，但是从MQ获取信息的时候是同步的，任何时候只有一个线程可以和MQ通信。
        this.mqQueueManager = new MQQueueManager(queueManagerName);
        return this.mqQueueManager;
    }

    /**
     * 断开连接
     *
     * @param qmr
     * @throws MQException
     */
    public void disconnect(MQQueueManager qmr) throws MQException {
        if (qmr != null) {
            qmr.disconnect();
        }
    }


    public MQQueueManager getMQQueueManager() {
        return this.mqQueueManager;
    }

    public ConcurrentHashMap<String, String> getMqConfigMap() {
        return mqConfigMap;
    }

}
