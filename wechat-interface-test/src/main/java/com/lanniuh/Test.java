package com.lanniuh;

import cn.joinhealth.bean.reply.ReplyMsg;
import cn.joinhealth.bean.request.RequestMsg;
import com.alibaba.fastjson.JSON;
import com.lanniuh.api.WeChatService;
import com.lanniuh.module.Questionnaire;
import com.lanniuh.module.ReferralReminder;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by linjian
 * 16/8/19.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("-------------------111----------------------");
//        testSendQuestionnaire();
//        System.out.println("-------------------2222---------------------");
//        testSendReferralReminder();
        assemblyH5Url();
    }

    public static void testSendQuestionnaire() {
        Logger log = Logger.getLogger(Test.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        WeChatService weChatService = context.getBean("weChatService", WeChatService.class);
        RequestMsg requestMsg = new RequestMsg();
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setYid("随访宣教信息id");
        questionnaire.setHospCode("");
        questionnaire.setPatName("林剑");
        questionnaire.setVisitCardNo("1000000171777");
        questionnaire.setVisitCardType("1");
        questionnaire.setIdCard("330225198810260359");
        questionnaire.setMobileNo("15067172995");
        questionnaire.setFollowupName("测试医生");
        questionnaire.setFollowupType("1");
        questionnaire.setMsgType("1");
        questionnaire.setFollowupTime("2016-08-19");
        questionnaire.setTitle("测试问卷123");
        questionnaire.setMsgUrl("http://www.lanniuh.com");
        questionnaire.setDeptName("测试科室");
        requestMsg.setBody(questionnaire);
        log.info("requestMsg" + JSON.toJSONString(requestMsg));
        System.out.println("requestMsg: " + requestMsg);
        ReplyMsg replyMsg = weChatService.sendQuestionnaire(requestMsg);
        System.out.println("replyMsg: " + replyMsg);
        log.info("replyMsg" + JSON.toJSONString(replyMsg));
    }

    public static void testSendReferralReminder() {
        Logger log = Logger.getLogger(Test.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        WeChatService weChatService = context.getBean("weChatService", WeChatService.class);
        RequestMsg requestMsg = new RequestMsg();
        ReferralReminder referralReminder = new ReferralReminder();
        referralReminder.setHospCode("");
        referralReminder.setPatName("林剑");
        referralReminder.setVisitCardNo("1000000171777");
        referralReminder.setVisitCardType("1");
        referralReminder.setIdCard("330225198810260359");
        referralReminder.setMobileNo("15067172995");
        referralReminder.setFollowupName("测试医生");
        referralReminder.setFollowupType("1");
        referralReminder.setFollowupTime("2016-08-19");
        referralReminder.setAddress("复诊地址");
        referralReminder.setContent("复诊内容：注意事项");
        requestMsg.setBody(referralReminder);
        log.info("requestMsg" + JSON.toJSONString(requestMsg));
        System.out.println("requestMsg: " + requestMsg);
        ReplyMsg replyMsg = weChatService.sendReferralReminder(requestMsg);
        System.out.println("replyMsg: " + replyMsg);
        log.info("replyMsg" + JSON.toJSONString(replyMsg));
    }

    public static void assemblyH5Url() {
//        String url = "http://121.40.185.58:3000/mobile/medical/patient/medicalRecord/query?";
        String url = "http://www.lanniuh.com:8060/mobile/medical/hospital/medicalRecord/query?";
        String partnerId = "wx_gzfnetylzx";
        String partnerType = "1001";
        String key = "76a42dc029ef43b9bc8d56f3831015ed";
        long time = System.currentTimeMillis();
        String md5 = DigestUtils.md5Hex(partnerId + String.valueOf(time) + key).toUpperCase();
        String cardNo = "4401000002023348";
//        String cardNo = "4401000014136683";
        String cardType = "1";
        String hospCode = "683292136";
//        String patName = "何梓华";
        String patName = "%E9%83%91%E9%B9%8F";
        url = url+"partnerId="+partnerId+"&partnerType="+partnerType+"&time="+time+"&md5="+md5+"&cardNo="+cardNo+"&cardType="+cardType+"&hospCode="+hospCode+"&patName="+patName;
        System.out.println(url);

//        http://www.lanniuh.com:8060/mobile/medical/patient/medicalRecord/query?partnerId=wx_gzfnetylzx&partnerType=1001&time=1473409991366&md5=3825D4213560F76C430FB22BA3D61BC7&cardNo=4401000014136683&cardType=1&hospCode=683292136&patName=%E9%83%91%E9%B9%8F

    }
}
