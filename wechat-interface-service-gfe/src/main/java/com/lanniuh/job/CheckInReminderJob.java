package com.lanniuh.job;

import com.lanniuh.checkinreminder.model.CheckInReminder;
import com.lanniuh.checkinreminder.service.CheckInReminderService;
import com.lanniuh.checkinreminder.thread.CheckInReminderThread;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by linjian
 * 16/9/8.
 */
public class CheckInReminderJob {
    @Resource
    private CheckInReminderService checkInReminderService;

    public void checkInReminderJob(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -5);
        Date endDate = calendar.getTime();
        calendar.add(Calendar.SECOND, -5);
        Date startDate = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String startTime = sdf.format(startDate);
        String endTime = sdf.format(endDate);

//        String nowTime = sdf.format(new Date());
//        System.out.println("Check in reminder now Time: " + nowTime + "startTime: " + startTime + "  endTime: "+ endTime);

        Map params = new HashMap();

        params.put("startTime", startTime);
        params.put("endTime", endTime);
        List<CheckInReminder> checkInReminders = checkInReminderService.getCheckedPatient(params);

        if (checkInReminders.size() > 0){
            Thread thread = new CheckInReminderThread(checkInReminders);
            thread.start();
        }

    }
}
