package com.lanniuh;

import cn.joinhealth.bean.reply.ReplyMsg;
import cn.joinhealth.bean.request.RequestMsg;
import com.alibaba.fastjson.JSON;
import com.lanniuh.api.WeChatService;
import com.lanniuh.module.Questionnaire;
import com.lanniuh.module.ReferralReminder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linjian
 * 16/8/30.
 */
public class WeChatTest {
    ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("context.xml");
    }
//
//    public static void main(String[] args) {
//        System.out.println("-------------------111----------------------");
//        testSendQuestionnaire();
//        System.out.println("-------------------2222---------------------");
//     testSendReferralReminder();
//    }

    @org.junit.Test
    public void testSendQuestionnaire(){
        Logger logger = Logger.getLogger(WeChatTest.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        WeChatService weChatService = context.getBean("weChatService", WeChatService.class);
        RequestMsg requestMsg = new RequestMsg();
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setYid("随访宣教信息id");
        questionnaire.setHospCode("683292136");
        questionnaire.setPatName("林剑");
        questionnaire.setIdCard("330225198810260359");
        questionnaire.setMobileNo("15067172995");
        questionnaire.setVisitCardNo("1000000171777");
        questionnaire.setVisitCardType("1");
        questionnaire.setFollowupName("测试医生");
        questionnaire.setFollowupType("1");
        questionnaire.setMsgType("7");
        questionnaire.setFollowupTime("2016-08-19");
        questionnaire.setTitle("入院宣教");
        questionnaire.setMsgUrl("http://www.lanniuh.com");
        questionnaire.setDeptName("测试科室");
        requestMsg.setBody(questionnaire);

        System.out.println("requestMsg: " + requestMsg);
        logger.info("requestMsg: " + JSON.toJSONString(requestMsg));
        System.out.println("requestMsg: " + requestMsg);
        ReplyMsg replyMsg = weChatService.sendQuestionnaire(requestMsg);
        System.out.println("replyMsg: " + replyMsg);
        logger.info("replyMsg: " + JSON.toJSONString(replyMsg));
    }

    @org.junit.Test
    public void testSendReferralReminder(){
        Logger logger = Logger.getLogger(WeChatTest.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        WeChatService weChatService = context.getBean("weChatService", WeChatService.class);
        RequestMsg requestMsg = new RequestMsg();
        ReferralReminder referralReminder = new ReferralReminder();
        referralReminder.setHospCode("683292136");
        referralReminder.setPatName("林剑");
        referralReminder.setIdCard("330225198810260359");
        referralReminder.setMobileNo("15067172995");
        referralReminder.setVisitCardNo("1000000171777");
        referralReminder.setVisitCardType("1");
        referralReminder.setFollowupName("测试医生");
        referralReminder.setFollowupType("1");
        referralReminder.setFollowupTime("2016-08-19");
        referralReminder.setAddress("复诊地址");
        referralReminder.setContent("复诊内容");
        requestMsg.setBody(referralReminder);

        System.out.println("requestMsg: " + requestMsg);
        logger.info("requestMsg: " + JSON.toJSONString(requestMsg));
        ReplyMsg replyMsg = weChatService.sendReferralReminder(requestMsg);
        System.out.println("replyMsg: " + replyMsg);
        logger.info("replyMsg: " + JSON.toJSONString(replyMsg));
    }
}
