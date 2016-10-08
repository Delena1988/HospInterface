package com.lanniuh.referralreminderrecord.handle;

import cn.joinhealth.pub_manager.utils.StringUtil;
import com.lanniuh.module.ReferralReminder;
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
public class ReferralReminderHandle {
    /**
     * 组装xml格式请求
     * @param referralReminder
     * @return
     */
    public static String assemblyXmlReq(ReferralReminder referralReminder){
        String method = "revisitNotice001";
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
        code.setText("revisitNotice001");
        param.add(new BaseElement("hospitalId").addText(hospitalId));
        param.add(new BaseElement("signature").addText(signature));
        param.add(new BaseElement("nonceStr").addText(nonceStr));
        param.add(new BaseElement("channel").addText(channel));
        param.add(new BaseElement("openId").addText(openId));
        addElement(param,"patName",referralReminder.getPatName());
        addElement(param,"patIdCard",referralReminder.getIdCard());
        addElement(param,"patMobile",referralReminder.getMobileNo());
        addElement(param,"patMedType",referralReminder.getVisitCardType());
        addElement(param,"patMedNo",referralReminder.getVisitCardNo());
        addElement(param,"followupName",referralReminder.getFollowupName());
        addElement(param,"followupType",referralReminder.getFollowupType());
        addElement(param,"followupTime",referralReminder.getFollowupTime());
        addElement(param,"address",referralReminder.getAddress());
        addElement(param,"content",referralReminder.getContent());

        return document.asXML();
    }
    private static void addElement(Element parent,String elementName,String value){
        Element element = new BaseElement(elementName);
        parent.add(element);
        if (!StringUtil.isEmpty(value)){
            element.addText(value);
        }
    }
}
