package com.lanniuh.checkinreminder.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanniuh.checkinreminder.model.CheckInReminder;
import com.lanniuh.util.PropertiesUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.UUID;


/**
 * Created by linjian
 * 16/8/29.
 */
public class CheckInReminderHandle {
    /**
     * 组装xml格式请求
     * @param checkInReminder
     * @return
     */
    public static String assemblyWeChatXmlReq(CheckInReminder checkInReminder){
        String method = "sendWXTemplateMessage001";
        String hospitalId = PropertiesUtil.getInstanse().gethospitalId();
        String nonceStr = UUID.randomUUID().toString().replace("-","");
        String openId = PropertiesUtil.getInstanse().getOpenId();
        String key = PropertiesUtil.getInstanse().getKey();
        String channel = PropertiesUtil.getInstanse().getChannel();
        String temp = "hospitalId="+hospitalId+"&method="+method+"&nonceStr="+nonceStr+"&openId="+openId+"&key="+key;
        String signature = DigestUtils.shaHex(temp).toUpperCase();

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("request");
        Element code = new BaseElement("methodCode");
        Element param = new BaseElement("methodParam");
        root.add(code);
        root.add(param);
        code.setText("sendWXTemplateMessage001");
        param.add(new BaseElement("hospitalId").addText(hospitalId));
        param.add(new BaseElement("signature").addText(signature));
        param.add(new BaseElement("nonceStr").addText(nonceStr));
        param.add(new BaseElement("channel").addText(channel));
        param.add(new BaseElement("openId").addText(openId));
        param.add(new BaseElement("patMedNo").addText(checkInReminder.getHealthNum()));
        param.add(new BaseElement("patMedType").addText("2"));
        param.add(new BaseElement("patName").addText(checkInReminder.getUsername()));
        Element messageContent = new BaseElement("messageContent");
        messageContent.addCDATA(assemblyJson(checkInReminder.getUsername()+",您已报到成功，请注意叫号信息！首诊患者请到护士台登记！此次测量结果为：",
                checkInReminder.getBdTime(),
                checkInReminder.getHeight()+"cm",
                checkInReminder.getWeight()+"kg",
                checkInReminder.getSystolicPressure().intValue()+"／"+checkInReminder.getDiastolicPressure().intValue()+"mmhg",
                ""));
        param.add(messageContent);

        return document.asXML();
    }


    /**
     * 组装xml格式请求
     *
     * @param checkInReminder
     * @return
     */
    public static String assemblyShortXmlReq(CheckInReminder checkInReminder) {
        String method = "sendShortMessage001";
        String hospitalId = PropertiesUtil.getInstanse().gethospitalId();
        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        String openId = PropertiesUtil.getInstanse().getShortOpenId();
        String key = PropertiesUtil.getInstanse().getShortKey();
        String channel = PropertiesUtil.getInstanse().getShortChannel();
        String temp = "hospitalId=" + hospitalId + "&method=" + method + "&nonceStr=" + nonceStr + "&openId=" + openId + "&key=" + key;
        String signature = DigestUtils.shaHex(temp).toUpperCase();

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("request");
        Element code = new BaseElement("methodCode");
        Element param = new BaseElement("methodParam");
        root.add(code);
        root.add(param);
        code.setText("sendShortMessage001");
        param.add(new BaseElement("hospitalId").addText(hospitalId));
        param.add(new BaseElement("signature").addText(signature));
        param.add(new BaseElement("nonceStr").addText(nonceStr));
        param.add(new BaseElement("channel").addText(channel));
        param.add(new BaseElement("openId").addText(openId));
        param.add(new BaseElement("receiveName").addText(checkInReminder.getUsername()));
        param.add(new BaseElement("receiverType").addText("2"));
        param.add(new BaseElement("patMedNo").addText(checkInReminder.getHealthNum()));
        param.add(new BaseElement("patMedType"));
        param.add(new BaseElement("mobile"));
        param.add(new BaseElement("staffNo"));
        String testRes = "此次测量结果为：身高" + checkInReminder.getHeight()
                + "cm  体重:" + checkInReminder.getWeight()
                + "kg  血压:" + checkInReminder.getSystolicPressure().intValue() + "／" + checkInReminder.getDiastolicPressure().intValue()
                + "mmhg";
        param.add(new BaseElement("content").addText("您已报到成功，请注意叫号信息！首诊患者请到护士台登记！" + testRes + "【广州妇女儿童医疗中心】"));
        param.add(new BaseElement("resource"));

        return document.asXML();
    }


    private static String assemblyJson(String firstStr,String keyword1Str,String keyword2Str,String keyword3Str,String keyword4Str,String remarkStr){
        JSONObject json = new JSONObject();
        json.put("touser", "#touser");
        json.put("template_id", "MGfUze5JXd5TmRnJy6cW-tEL_wBdI_598b6nTHPxMRw");
        json.put("url", "");
        json.put("topcolor", "#FF0000");
        JSONObject data = new JSONObject();
        JSONObject first = new JSONObject();
        first.put("value", firstStr);
        first.put("color", "#173177");
        JSONObject keyword1 = new JSONObject();
        keyword1.put("value", keyword1Str);
        keyword1.put("color", "#173177");
        JSONObject keyword2 = new JSONObject();
        keyword2.put("value", keyword2Str);
        keyword2.put("color", "#173177");
        JSONObject keyword3 = new JSONObject();
        keyword3.put("value", keyword3Str);
        keyword3.put("color", "#173177");
        JSONObject keyword4 = new JSONObject();
        keyword4.put("value", keyword4Str);
        keyword4.put("color", "#173177");
        JSONObject remark = new JSONObject();
        remark.put("value", remarkStr);
        remark.put("color", "#173177");
        data.put("first", first);
        data.put("keyword1", keyword1);
        data.put("keyword2", keyword2);
        data.put("keyword3", keyword3);
        data.put("keyword4", keyword4);
        json.put("data", data);
        json.put("remark", remark);
        return JSON.toJSONString(json);
    }

    public static void main(String[] args) {
        CheckInReminder checkInReminder = new CheckInReminder();
        checkInReminder.setUsername("林剑");
        checkInReminder.setHealthNum("1000000171777");
        checkInReminder.setBdTime("2016-09-08 19:00:00");
        checkInReminder.setHeight((double) 175);
        checkInReminder.setWeight((double) 62);
        checkInReminder.setSystolicPressure((double) 110);
        checkInReminder.setDiastolicPressure((double) 65);

//        checkInReminder.setUsername("曾海霞");
//        checkInReminder.setHealthNum("4401000011270856");
//        checkInReminder.setBdTime("2016-09-08 13:00:46");
//        checkInReminder.setPulse((double)93);
//        checkInReminder.setHeight(157.5);
//        checkInReminder.setWeight(70.7);
//        checkInReminder.setSystolicPressure((double)112);
//        checkInReminder.setDiastolicPressure((double)58);
        System.out.println(assemblyWeChatXmlReq(checkInReminder));

//        String method = "sendHealthEducationQuestionnaire001";
//        String hospitalId = PropertiesUtil.getInstanse().gethospitalId();
//        String nonceStr = "0a4bdb35eb0d4f5ba8c8e9bdd1374e65";
//        String openId = "TEST";
//        String key = "6BB30AAE2804144011040E664D87AC5452246969";
//        String channel = "TEST";
//        String temp = "hospitalId="+hospitalId+"&method="+method+"&nonceStr="+nonceStr+"&openId="+openId+"&key="+key;
//        String signature = DigestUtils.shaHex(temp).toUpperCase();
//        System.out.println(signature);
    }
}
