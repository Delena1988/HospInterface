package com.lanniuh.checkinreminder.thread;

import com._100wit.www.HisServiceStub;
import com.lanniuh.checkinrecord.model.CheckInRecord;
import com.lanniuh.checkinrecord.service.CheckInRecordService;
import com.lanniuh.checkinreminder.handle.CheckInReminderHandle;
import com.lanniuh.checkinreminder.model.CheckInReminder;
import com.lanniuh.util.PropertiesUtil;
import com.lanniuh.util.SpringContextUtil;
import com.lanniuh.util.XmlUtil;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by linjian
 * 16/9/8.
 */
public class CheckInReminderThread extends Thread {
    Logger logger = Logger.getLogger(CheckInReminderThread.class);
    private List<CheckInReminder> checkInReminders;

    public CheckInReminderThread(List<CheckInReminder> checkInReminders) {
        this.checkInReminders = checkInReminders;
    }

    @Override
    public void run() {
        for (CheckInReminder checkInReminder : checkInReminders) {
            sendWeChatMessage(checkInReminder);
        }
    }

    //发送报到提醒   微信消息
    public void sendWeChatMessage(CheckInReminder checkInReminder) {
        String reqXml = CheckInReminderHandle.assemblyWeChatXmlReq(checkInReminder);
        logger.info("weChat: " + reqXml);
        String res = invokeWeChat(reqXml);
        logger.info("send wechat message res: " + res);
        if (!"0".equals(res)) {
            sendShortMessage(checkInReminder);
        } else {
            //safe record
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            CheckInRecord checkInRecord = new CheckInRecord();
            checkInRecord.setId(UUID.randomUUID().toString().replace("-", ""));
            checkInRecord.setPatName(checkInReminder.getUsername());
            checkInRecord.setVisitCardNo(checkInReminder.getHealthNum());
            Date checkInTime = null;
            try {
                checkInTime = sdf.parse(checkInReminder.getBdTime());
            } catch (ParseException e) {
                e.printStackTrace();
                logger.info(e.getMessage());
            }
            checkInRecord.setCheckInTime(checkInTime);
            checkInRecord.setReminderTime(new Date());
            checkInRecord.setReturnCode("0");
            checkInRecord.setMsgType("WeChat");
            try {
                CheckInRecordService checkInRecordService = SpringContextUtil.getBean("checkInRecordService");
                checkInRecordService.insert(checkInRecord);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    //发送报到提醒   短信
    private void sendShortMessage(CheckInReminder checkInReminder) {
        String reqXml = CheckInReminderHandle.assemblyShortXmlReq(checkInReminder);
        logger.info("shortMessage: " + reqXml);
        String res = invokeWeChat(reqXml);
        logger.info("send short msg res: " + res);
        //safe record
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CheckInRecord checkInRecord = new CheckInRecord();
        checkInRecord.setId(UUID.randomUUID().toString().replace("-", ""));
        checkInRecord.setPatName(checkInReminder.getUsername());
        checkInRecord.setVisitCardNo(checkInReminder.getHealthNum());
        Date checkInTime = null;
        try {
            checkInTime = sdf.parse(checkInReminder.getBdTime());
        } catch (ParseException e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
        checkInRecord.setCheckInTime(checkInTime);
        checkInRecord.setReminderTime(new Date());
        checkInRecord.setReturnCode(res);
        checkInRecord.setMsgType("ShortMsg");
        try {
            CheckInRecordService checkInRecordService = SpringContextUtil.getBean("checkInRecordService");
            checkInRecordService.insert(checkInRecord);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    //调用微信发送接口
    private String invokeWeChat(String reqXml) {
        try {
            String targetEndpoint = PropertiesUtil.getInstanse().getUrl();
            HisServiceStub stub = new HisServiceStub(targetEndpoint);
            ServiceClient client = stub._getServiceClient();
            Options options = stub._getServiceClient().getOptions();
            options.setManageSession(true);
            options.setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);
            options.setTimeOutInMilliSeconds(1000 * 20);

            HisServiceStub.HisForHzfwhService hisForHzfwhService = new HisServiceStub.HisForHzfwhService();
            hisForHzfwhService.setInputXml(reqXml);
            HisServiceStub.HisForHzfwhServiceE hisForHzfwhServiceE = new HisServiceStub.HisForHzfwhServiceE();
            hisForHzfwhServiceE.setHisForHzfwhService(hisForHzfwhService);
            String result = stub.hisForHzfwhService(hisForHzfwhServiceE).getHisForHzfwhServiceResponse().get_return();
            client.cleanupTransport();
            client.cleanup();
            stub.cleanup();

            logger.info("result: " + result);

            Document document = XmlUtil.str2Doc(result);
            Element root = document.getRootElement();
            String returnCode = root.selectSingleNode("//returnCode").getText();
            return returnCode;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

}
