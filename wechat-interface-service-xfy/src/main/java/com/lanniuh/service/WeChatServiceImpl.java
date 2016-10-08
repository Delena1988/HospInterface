package com.lanniuh.service;

import cn.joinhealth.bean.reply.ReplyMsg;
import cn.joinhealth.bean.request.RequestMsg;
import com.alibaba.fastjson.JSON;
import com.ibm.mq.MQException;
import com.ibm.mq.MQQueueManager;
import com.lanniuh.api.WeChatService;
import com.lanniuh.handle.QuestionnaireHandle;
import com.lanniuh.module.Questionnaire;
import com.lanniuh.module.ResultMsg;
import com.lanniuh.mq.ConnectFactory;
import com.lanniuh.util.XmlUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import java.io.IOException;

/**
 * Created by linjian
 * 16/8/18.
 */
public class WeChatServiceImpl implements WeChatService {
    private static Logger logger = Logger.getLogger(WeChatServiceImpl.class);

    private static MQQueueManager queueManager = null;
    static {
        try {
            // 队列管理器实例
            queueManager = ConnectFactory.getInstance().connectMQ();
        } catch (MQException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ReplyMsg sendReferralReminder(RequestMsg requestMsg) {
        return null;
    }

    @Override
    public ReplyMsg sendQuestionnaire(RequestMsg requestMsg) {
        Questionnaire questionnaire = JSON.parseObject(requestMsg.getBody(), Questionnaire.class);

        String reqXml = QuestionnaireHandle.assemblyXmlReq(questionnaire);
        //invoke MQ service
        // 消息Id
        String msgId = null;
        // 请求数据
        String reqMsg = reqXml;
        // 响应数据
        String respMsg = null;

        try {
            if (queueManager == null || !queueManager.isConnected()) {
                queueManager = ConnectFactory.getInstance().connectMQ();
            }
            msgId = ConnectFactory.getInstance().putMsg(queueManager, "BS10100", reqMsg);
            logger.debug("reqMsg: " + reqMsg);
            respMsg = ConnectFactory.getInstance().getMsgById(queueManager, "BS10100", msgId);
            logger.debug("respMsg: " + respMsg);
            String s = null;
            Document document = XmlUtil.str2Doc(respMsg);
            Element e = (Element) document.selectNodes("ESBEntry/return").get(0);
            s = e.getStringValue();
            if (s != null) {
                Document document1 = XmlUtil.str2Doc(s);
                Element stateElement = (Element) document1.selectSingleNode("//state");
                if ("0".equals(stateElement.getText())) {
                    return invokeSuccessed();
                }
            }
            return invokeFailed();
        } catch (MQException e) {
            e.printStackTrace();
            return invokeFailed();
        } catch (IOException e) {
            e.printStackTrace();
            return invokeFailed();
        }
    }
    private static ReplyMsg invokeFailed(){
        ResultMsg resultMsg = new ResultMsg("-1", "调用微信接口失败");
        ReplyMsg replyMsg = new ReplyMsg();
        replyMsg.setBody(resultMsg);
        logger.debug("调用微信接口失败: " + JSON.toJSONString(resultMsg));
        return replyMsg;
    }

    private static ReplyMsg invokeSuccessed(){
        ResultMsg resultMsg = new ResultMsg("0", "调用微信接口成功");
        ReplyMsg replyMsg = new ReplyMsg();
        replyMsg.setBody(resultMsg);
        logger.debug("调用微信接口成功: " + JSON.toJSONString(resultMsg));
        return replyMsg;
    }

   
}
