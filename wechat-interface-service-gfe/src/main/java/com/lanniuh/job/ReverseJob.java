package com.lanniuh.job;

import com.lanniuh.reverse.model.Reverse;
import com.lanniuh.reverse.service.ReverseService;
import com.lanniuh.reverse.thread.ReverseThread;
import com.lanniuh.util.PropertiesUtil;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by linjian
 * 16/9/13.
 */
public class ReverseJob {
    @Resource
    private ReverseService reverseService;

    private static List<String> filingDeptList;
    private static String deptCode = " and dept_code in (";
    static{
        String filingDept = PropertiesUtil.getInstanse().getFilingDept();
        filingDeptList = Arrays.asList(filingDept.split(","));
        for (String str:filingDeptList) {
            deptCode = deptCode + "'" + str + "',";
        }
        deptCode = deptCode.substring(0, deptCode.length()-1) + ")";
    }

    public void reverseJob() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -5);
        Date endDate = calendar.getTime();
        calendar.add(Calendar.SECOND, -5);
        Date startDate = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String startTime = sdf.format(startDate);
        String endTime = sdf.format(endDate);

//        String nowTime = sdf.format(new Date());
//        System.out.println("Reverse now Time: " + nowTime + "startTime: " + startTime + "  endTime: "+ endTime);
//        System.out.println("deptCode: " + deptCode);

        Map params = new HashMap();

        if (filingDeptList.size()>0){
            params.put("deptCode",deptCode);
        }
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Reverse> reverses = reverseService.getReverse(params);

        if (reverses.size() > 0) {
            Thread thread = new ReverseThread(reverses);
            thread.start();
        }
    }
}
