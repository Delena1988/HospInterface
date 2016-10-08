package com.lanniuh;

import com.alibaba.fastjson.JSON;
import com.lanniuh.checkinreminder.model.CheckInReminder;
import com.lanniuh.checkinreminder.service.CheckInReminderService;
import com.lanniuh.checkinreminder.thread.CheckInReminderThread;
import com.lanniuh.pregnantprofile.model.SelfPregnantInfo;
import com.lanniuh.pregnantprofile.service.PregnantProfileService;
import com.lanniuh.questionnairerecord.model.QuestionnaireRecord;
import com.lanniuh.questionnairerecord.service.QuestionnaireRecordService;
import com.lanniuh.reverse.model.Reverse;
import com.lanniuh.reverse.service.ReverseService;
import com.lanniuh.reverse.thread.ReverseThread;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by linjian
 * 16/8/29.
 */
public class QuestionnaireTest {
    ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("context.xml");
    }

    @Test
    public void test1() {
        QuestionnaireRecordService questionnaireRecordService = context.getBean("questionnaireRecordService",QuestionnaireRecordService.class);
        QuestionnaireRecord questionnaireRecord = new QuestionnaireRecord();
        questionnaireRecord.setId("1");
        questionnaireRecord.setThirdCode("S01");
        questionnaireRecord.setYid("1001");
        questionnaireRecord.setPatName("林剑");
        questionnaireRecord.setHospCode("683292136");
        questionnaireRecord.setIdCard("330225198810260359");
        questionnaireRecord.setMobileNo("15067172995");
        questionnaireRecord.setCardNo("100010000200003");
        questionnaireRecord.setCardType("1");
        questionnaireRecord.setFollowupName("随访医生");
        questionnaireRecord.setFollowupType("1");
        questionnaireRecord.setMsgType("1");
        questionnaireRecord.setFollowupTime(new Date());
        questionnaireRecord.setTitle("宣教标题");
        questionnaireRecord.setMsgUrl("http://www.baidu.com");
        questionnaireRecord.setDeptName("宣教科室");
        questionnaireRecord.setReturnCode("0");
        questionnaireRecord.setReturnMsg("发送成功");
        System.out.println(questionnaireRecordService.insert(questionnaireRecord));
    }

    @Test
    public void test2() {
        CheckInReminderService checkInReminderService = context.getBean("checkInReminderService", CheckInReminderService.class);
        Map<String,String> params = new HashMap<String,String>();
        params.put("startTime","2016-09-08 09:00:00");
        params.put("endTime","2016-09-08 09:20:00");
        List<CheckInReminder> checkInReminders = checkInReminderService.getCheckedPatient(params);
        for (CheckInReminder checkInReminder : checkInReminders) {
            System.out.println(checkInReminder.toString());
        }
    }

    @Test
    public void test3(){
        List<CheckInReminder> checkInReminders = new ArrayList<CheckInReminder>();
        CheckInReminder checkInReminder = new CheckInReminder();
        checkInReminder.setUsername("林剑");
        checkInReminder.setHealthNum("1000000171777");
        checkInReminder.setBdTime("2016-09-08 19:00:00");
        checkInReminder.setHeight((double) 175);
        checkInReminder.setWeight((double) 62);
        checkInReminder.setSystolicPressure((double) 110);
        checkInReminder.setDiastolicPressure((double) 65);
        checkInReminders.add(checkInReminder);
        CheckInReminderThread checkInReminderThread = new CheckInReminderThread(checkInReminders);
        checkInReminderThread.sendWeChatMessage(checkInReminder);
    }

    @Test
    public void testReverse(){
        System.out.println("start----------------------");
//        ReverseService reverseService  = context.getBean("reverseService", ReverseService.class);
//        Reverse reverse = new Reverse();
//        reverse.setOrganCode("683292136");
//        reverse.setPatName("赖慧");
//        reverse.setVisitCardNo("4401000009305812");
//        reverse.setDeptCode("20034");
//
//        reverse.setPatName("江韵思");
//        reverse.setVisitCardNo("1000000090955");
//        reverse.setDeptCode("20034");
//        int res = reverseService.firstVisit(reverse);
//        System.out.println("res: " + res);

        Reverse reverse = new Reverse();
        reverse.setOrganCode("683292136");
        reverse.setPatName("林剑");
        reverse.setIdNumber("330225198810260359");
        reverse.setVisitCardNo("100000171777");
        reverse.setDeptCode("20034");

        List<Reverse> reverses = new ArrayList<>();
        reverses.add(reverse);
        ReverseThread reverseThread = new ReverseThread(reverses);
        reverseThread.start();

    }

    @Test
    public void testPregnant(){
        System.out.println("-------------start---------------");
        try {
            Thread.sleep(1000*1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelfPregnant(){
        PregnantProfileService pregnantProfileService = context.getBean("pregnantProfileService",PregnantProfileService.class);
        Map<String,String> params = new HashMap<>();
        params.put("startTime","2016-09-20 :00:00:00");
        params.put("endTime","2016-09-21 23:59:59");
        List<SelfPregnantInfo> selfPregnantInfos = pregnantProfileService.getSelfPregnantInfo(params);
        for (SelfPregnantInfo selfPregnantInfo: selfPregnantInfos) {
            System.out.println(JSON.toJSONString(selfPregnantInfo));
        }
    }

    @Test
    public void testGetCardProc(){
        ReverseService reverseService = context.getBean("reverseService", ReverseService.class);
        System.out.println(reverseService.getVisitCardNo("10000171777"));
    }
}
