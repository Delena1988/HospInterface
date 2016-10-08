package com.lanniuh.pregnantprofile.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanniuh.pregnantprofile.model.SelfPregnantInfo;
import com.lanniuh.pregnantprofile.token.Token;
import com.lanniuh.pregnantprofilerecord.model.PregnantProfileRecord;
import com.lanniuh.pregnantprofilerecord.service.PregnantProfileRecordService;
import com.lanniuh.util.HttpUtil;
import com.lanniuh.util.PropertiesUtil;
import com.lanniuh.util.SpringContextUtil;
import com.lanniuh.util.StringUtil;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by linjian
 * 16/9/8.
 */
public class PregnantProfileThread extends Thread {
    private static Logger logger = Logger.getLogger(PregnantProfileThread.class);
    private List<SelfPregnantInfo> selfPregnantInfos;

    public PregnantProfileThread(List<SelfPregnantInfo> selfPregnantInfos) {
        this.selfPregnantInfos = selfPregnantInfos;
    }

    @Override
    public void run() {
        for (SelfPregnantInfo selfPregnantInfo : selfPregnantInfos) {
            invokeHeLeInterface(selfPregnantInfo);
        }
    }

    //invoke hele interface
    public static void invokeHeLeInterface(SelfPregnantInfo selfPregnantInfo) {
        //获取url
        String url = PropertiesUtil.getInstanse().getHeLeUrl();
        //获取token
        String token = Token.getToken();
        if (StringUtil.isEmpty(token)){
            Token.getInstance().resetToken();
            token = Token.getToken();
        }

        if (selfPregnantInfo.getCreatetime().equals(selfPregnantInfo.getUpdatetime())){
            selfPregnantInfo.setId(0);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appid","fezx");
        jsonObject.put("token",token);
        jsonObject.put("selfpregnantinfo", selfPregnantInfo);
        jsonObject.put("type",1003);


        logger.info("req: " + JSON.toJSONString(jsonObject));
        String res = HttpUtil.sendPostHeLe(url,JSON.toJSONString(jsonObject));
        logger.info("res: " + res);


        JSONObject json = JSON.parseObject(res);
        int result = json.getIntValue("result");
        String errormsg = json.getString("errormsg");
        //token过期
        if (!StringUtil.isEmpty(errormsg) && errormsg.contains("认证")){
            Token.getInstance().resetToken();
            token = Token.getToken();
            jsonObject.put("token", token);
            logger.info("reset token req: " + JSON.toJSONString(jsonObject));
            res = HttpUtil.sendPostHeLe(url, JSON.toJSONString(jsonObject));
            logger.info("reset token res: " + res);
            json = JSON.parseObject(res);
            result = json.getIntValue("result");
            errormsg = json.getString("errormsg");
        }

        //save record
        PregnantProfileRecordService pregnantProfileRecordService = SpringContextUtil.getBean("pregnantProfileRecordService");
        PregnantProfileRecord pregnantProfileRecord = new PregnantProfileRecord();
        pregnantProfileRecord.setId(UUID.randomUUID().toString().replace("-",""));
        pregnantProfileRecord.setResult(result);
        pregnantProfileRecord.setErrormsg(errormsg);
        pregnantProfileRecord.setPushTime(new Date());
        pregnantProfileRecord.setReq(JSON.toJSONString(jsonObject));
        pregnantProfileRecord.setSelfpregnantinfos(res);
        pregnantProfileRecordService.insert(pregnantProfileRecord);
    }

}
