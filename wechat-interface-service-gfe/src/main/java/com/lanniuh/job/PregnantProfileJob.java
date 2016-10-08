package com.lanniuh.job;

import com.lanniuh.pregnantprofile.model.SelfPregnantInfo;
import com.lanniuh.pregnantprofile.service.PregnantProfileService;
import com.lanniuh.pregnantprofile.thread.PregnantProfileThread;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by linjian
 * 16/9/13.
 */
public class PregnantProfileJob {
    @Resource
    private PregnantProfileService pregnantProfileService;

    public void pregnantProfileJob() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -5);
        Date endDate = calendar.getTime();
        calendar.add(Calendar.SECOND, -5);
        Date startDate = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String startTime = sdf.format(startDate);
        String endTime = sdf.format(endDate);

//        String nowTime = sdf.format(new Date());
//        System.out.println("Pregnant now Time: " + nowTime + "startTime: " + startTime + "  endTime: "+ endTime);

        Map params = new HashMap();

//        startTime = "2016-09-10 09:50:00";
//        endTime = "2016-09-10 10:10:00";
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        List<SelfPregnantInfo> selfPregnantInfos = pregnantProfileService.getSelfPregnantInfo(params);

        if (selfPregnantInfos.size() > 0) {
            Thread thread = new PregnantProfileThread(selfPregnantInfos);
            thread.start();
        }

    }

}
