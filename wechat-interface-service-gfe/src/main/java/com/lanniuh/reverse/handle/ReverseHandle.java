package com.lanniuh.reverse.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanniuh.reverse.model.Reverse;
import com.lanniuh.util.PropertiesUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

import java.util.UUID;

/**
 * Created by linjian
 * 16/9/19.
 */
public class ReverseHandle {

    /**
     * 组装xml格式请求
     *
     * @param reverse
     * @return
     */
    public static String assemblyWeChatXmlReq(Reverse reverse, String url) {
        String method = "sendWXTemplateMessage001";
        String hospitalId = PropertiesUtil.getInstanse().gethospitalId();
        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        String openId = PropertiesUtil.getInstanse().getOpenId();
        String key = PropertiesUtil.getInstanse().getKey();
        String channel = PropertiesUtil.getInstanse().getChannel();
        String temp = "hospitalId=" + hospitalId + "&method=" + method + "&nonceStr=" + nonceStr + "&openId=" + openId + "&key=" + key;
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
        param.add(new BaseElement("patMedNo").addText(reverse.getVisitCardNo()));
        param.add(new BaseElement("patMedType").addText("2"));
        param.add(new BaseElement("patName").addText(reverse.getPatName()));
        Element messageContent = new BaseElement("messageContent");
        messageContent.addCDATA(assemblyJson(url, "自助建档是首次就诊的必要条件，请务必就诊前完成自助建档。",
                "广州市妇女儿童医院",
                "",
                reverse.getPatName(),
                "请认真填写相应内容！",
                "remark"));
        param.add(messageContent);

        return document.asXML();
    }

    private static String assemblyJson(String url, String firstStr, String keyword1Str, String keyword2Str, String keyword3Str, String keyword4Str, String remarkStr) {
        JSONObject json = new JSONObject();
        json.put("touser", "#touser");
        json.put("template_id", "YVokE-PFY2XJYY4_ehKeFR5iDvM0q4AG-GNzYz9GX1w");
        json.put("url", url);
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

    /**
     * 组装xml格式请求
     *
     * @param reverse
     * @return
     */
    public static String assemblyShortXmlReq(Reverse reverse, String url) {
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
        param.add(new BaseElement("receiveName").addText(reverse.getPatName()));
        param.add(new BaseElement("receiverType").addText("2"));
        param.add(new BaseElement("patMedNo").addText(reverse.getVisitCardNo()));
        param.add(new BaseElement("patMedType"));
        param.add(new BaseElement("mobile"));
        param.add(new BaseElement("staffNo"));
        String testRes = "";
        param.add(new BaseElement("content").addText("自助建档是首次就诊的必要条件，请务必就诊前完成自助建档，建档连接：" + url + " 请认真填写相应内容。【广州妇女儿童医疗中心】"));
        param.add(new BaseElement("resource"));

        return document.asXML();
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.setPatName("林剑");
        reverse.setVisitCardNo("1000000171777");
        System.out.println(assemblyWeChatXmlReq(reverse, "http://www.baidu.com"));
        System.out.println("------------------------");
        System.out.println(assemblyShortXmlReq(reverse, "http://www.baidu.com"));

    }
}
