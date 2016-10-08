package com.lanniuh.service;

import cn.joinhealth.bean.reply.ReplyMsg;
import cn.joinhealth.bean.request.RequestMsg;
import com._100wit.www.HisServiceStub;
import com.alibaba.fastjson.JSON;
import com.lanniuh.api.WeChatService;
import com.lanniuh.module.Questionnaire;
import com.lanniuh.module.ReferralReminder;
import com.lanniuh.module.ResultMsg;
import com.lanniuh.questionnairerecord.handle.QuestionnaireHandle;
import com.lanniuh.questionnairerecord.model.QuestionnaireRecord;
import com.lanniuh.questionnairerecord.service.QuestionnaireRecordService;
import com.lanniuh.referralreminderrecord.handle.ReferralReminderHandle;
import com.lanniuh.referralreminderrecord.model.ReferralReminderRecord;
import com.lanniuh.referralreminderrecord.service.ReferralReminderRecordService;
import com.lanniuh.reverse.service.ReverseService;
import com.lanniuh.util.PropertiesUtil;
import com.lanniuh.util.XmlUtil;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by linjian
 * 16/8/29.
 */
public class WeChatServiceImpl implements WeChatService {
    private static Logger logger = Logger.getLogger(WeChatServiceImpl.class);
    @Resource
    QuestionnaireRecordService questionnaireRecordService;
    @Resource
    ReferralReminderRecordService referralReminderRecordService;
    @Resource
    ReverseService reverseService;

    @Override
    public ReplyMsg sendQuestionnaire(RequestMsg requestMsg) {
        Questionnaire questionnaire = JSON.parseObject(requestMsg.getBody(), Questionnaire.class);

        String visitCardno = reverseService.getVisitCardNo(questionnaire.getVisitCardNo());
        questionnaire.setVisitCardNo(visitCardno);

        ResultMsg resultMsg = new ResultMsg();
        //invoke webservice
        try {
            logger.info(JSON.toJSONString(questionnaire));
            String reqXml = QuestionnaireHandle.assemblyXmlReq(questionnaire);
            logger.info("questionnaire reqXml: " + reqXml);

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

            logger.info("questionnaire resultXml: " + result);
            resultMsg = handleReturn(result);

            //safe record to db
            try{
                QuestionnaireRecord questionnaireRecord = new QuestionnaireRecord();
                questionnaireRecord.setId(UUID.randomUUID().toString().replace("-", ""));
                questionnaireRecord.setThirdCode(requestMsg.getServerCode());
                questionnaireRecord.setYid(questionnaire.getYid());
                questionnaireRecord.setPatName(questionnaire.getPatName());
                questionnaireRecord.setHospCode(questionnaire.getHospCode());
                questionnaireRecord.setIdCard(questionnaire.getIdCard());
                questionnaireRecord.setMobileNo(questionnaire.getMobileNo());
                questionnaireRecord.setCardNo(questionnaire.getVisitCardNo());
                questionnaireRecord.setCardType(questionnaire.getVisitCardType());
                questionnaireRecord.setFollowupName(questionnaire.getFollowupName());
                questionnaireRecord.setFollowupType(questionnaire.getFollowupType());
                questionnaireRecord.setMsgType(questionnaire.getMsgType());
                questionnaireRecord.setFollowupTime(new Date());
                questionnaireRecord.setTitle(questionnaire.getTitle());
                questionnaireRecord.setMsgUrl(questionnaire.getMsgUrl());
                questionnaireRecord.setDeptName(questionnaire.getDeptName());
                questionnaireRecord.setReturnCode(resultMsg.getCode());
                questionnaireRecord.setReturnMsg(resultMsg.getMsg());

                questionnaireRecordService.insert(questionnaireRecord);
            }catch (Exception e1){
                e1.printStackTrace();
                logger.error("safe questionnaire record error: " + e1.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode("-1");
            resultMsg.setMsg("发送失败");
        }


        ReplyMsg replyMsg = new ReplyMsg();
        replyMsg.setBody(resultMsg);
        return replyMsg;
    }

    @Override
    public ReplyMsg sendReferralReminder(RequestMsg requestMsg) {
        ReferralReminder referralReminder = JSON.parseObject(requestMsg.getBody(), ReferralReminder.class);

        String visitCardno = reverseService.getVisitCardNo(referralReminder.getVisitCardNo());
        referralReminder.setVisitCardNo(visitCardno);

        ResultMsg resultMsg = new ResultMsg();
        //invoke webservice
        try {
            String reqXml = ReferralReminderHandle.assemblyXmlReq(referralReminder);
            logger.info("referralReminder reqXml: " + reqXml);
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

            logger.info("referralReminder resultXml: " + result);
            resultMsg = handleReturn(result);

            //safe record to db
            try{
                ReferralReminderRecord referralReminderRecord = new ReferralReminderRecord();
                referralReminderRecord.setId(UUID.randomUUID().toString().replace("-",""));
                referralReminderRecord.setThirdCode(requestMsg.getServerCode());
                referralReminderRecord.setHospCode(referralReminder.getHospCode());
                referralReminderRecord.setPatName(referralReminder.getPatName());
                referralReminderRecord.setIdCard(referralReminder.getIdCard());
                referralReminderRecord.setMobileNo(referralReminder.getMobileNo());
                referralReminderRecord.setVisitCardNo(referralReminder.getVisitCardNo());
                referralReminderRecord.setVisitCardType(referralReminder.getVisitCardType());
                referralReminderRecord.setFollowupName(referralReminder.getFollowupName());
                referralReminderRecord.setFollowupType(referralReminder.getFollowupType());
                referralReminderRecord.setFollowupTime(referralReminder.getFollowupTime());
                referralReminderRecord.setAddress(referralReminder.getAddress());
                referralReminderRecord.setContent(referralReminder.getContent());
                referralReminderRecord.setSentTime(new Date());

                referralReminderRecordService.insert(referralReminderRecord);
            }catch (Exception e1){
                e1.printStackTrace();
                logger.error("safe referral reminder record error: " + e1.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode("-1");
            resultMsg.setMsg("发送失败");
        }


        ReplyMsg replyMsg = new ReplyMsg();
        replyMsg.setBody(resultMsg);
        return replyMsg;
    }

    public static ResultMsg handleReturn(String result) {
        ResultMsg resultMsg = new ResultMsg();
        Document document = XmlUtil.str2Doc(result);
        Element root = document.getRootElement();
        String returnCode = root.selectSingleNode("//returnCode").getText();
        String returnMsg = root.selectSingleNode("//returnMsg").getText();

        if ("0".equals(returnCode)) {
            resultMsg.setCode("0");
            resultMsg.setMsg("发送成功");
        } else {
            resultMsg.setCode("-1");
            resultMsg.setMsg(returnMsg);
        }
        return resultMsg;
    }

}
