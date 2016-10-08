package com.lanniuh.questionnairerecord.handle;

import cn.joinhealth.pub_manager.utils.StringUtil;
import com.lanniuh.module.Questionnaire;
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
public class QuestionnaireHandle {
    /**
     * 组装xml格式请求
     * @param questionnaire
     * @return
     */
    public static String assemblyXmlReq(Questionnaire questionnaire){
        String method = "sendHealthEducationQuestionnaire001";
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
        code.setText("sendHealthEducationQuestionnaire001");
        param.add(new BaseElement("hospitalId").addText(hospitalId));
        param.add(new BaseElement("signature").addText(signature));
        param.add(new BaseElement("nonceStr").addText(nonceStr));
        param.add(new BaseElement("channel").addText(channel));
        param.add(new BaseElement("openId").addText(openId));
        addElement(param,"yid",questionnaire.getYid());
        addElement(param,"patName",questionnaire.getPatName());
        addElement(param,"patIdCard",questionnaire.getIdCard());
        addElement(param,"patMobile",questionnaire.getMobileNo());
        addElement(param,"patMedType",questionnaire.getVisitCardType());
        addElement(param,"patMedNo",questionnaire.getVisitCardNo());
        addElement(param,"followupName",questionnaire.getFollowupName());
        addElement(param,"followupType",questionnaire.getFollowupType());
        addElement(param,"msgType",questionnaire.getMsgType());
        addElement(param,"followupTime",questionnaire.getFollowupTime());
        addElement(param,"title",questionnaire.getTitle());
        addElement(param,"msgUrl",questionnaire.getMsgUrl());
        addElement(param,"deptName",questionnaire.getDeptName());
        return document.asXML();
    }

    private static void addElement(Element parent,String elementName,String value){
        Element element = new BaseElement(elementName);
        parent.add(element);
        if (!StringUtil.isEmpty(value)){
            element.addText(value);
        }
    }

    public static void main(String[] args) {
        String method = "sendHealthEducationQuestionnaire001";
        String hospitalId = PropertiesUtil.getInstanse().gethospitalId();
        String nonceStr = "0a4bdb35eb0d4f5ba8c8e9bdd1374e65";
        String openId = "TEST";
        String key = "6BB30AAE2804144011040E664D87AC5452246969";
        String channel = "TEST";
        String temp = "hospitalId="+hospitalId+"&method="+method+"&nonceStr="+nonceStr+"&openId="+openId+"&key="+key;
        String signature = DigestUtils.shaHex(temp).toUpperCase();
        System.out.println(signature);
    }
}
