package com.lanniuh.handle;

import com.lanniuh.module.Questionnaire;
import com.lanniuh.util.StringUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.BaseElement;

/**
 * Created by linjian
 * 16/8/18.
 */
public class QuestionnaireHandle {
    /**
     * 组装xml格式请求
     * @param questionnaire
     * @return
     */
    public static String assemblyXmlReq(Questionnaire questionnaire){
        Document document = DocumentHelper.createDocument();
        Element root = new BaseElement("ESBEntry");
        Element head = new BaseElement("MessageHeader");
        Element msgInfo = new BaseElement("MsgInfo");
        Element msg = new BaseElement("Msg");
        document.add(root);
        root.add(head);
        root.add(msgInfo);
        head.add(new BaseElement("Fid").addText("BS10100"));
        head.add(new BaseElement("SourceSysCode").addText("S41"));
        head.add(new BaseElement("TargetSysCode").addText("S31"));
        head.add(new BaseElement("MsgDate"));
        msgInfo.add(msg);


        Document document1 = DocumentHelper.createDocument();
        Element root1 = new BaseElement("msg");
        document1.add(root1);
        Element body = new BaseElement("body");
        root1.add(body);
        Element row = new BaseElement("row");
        body.add(row);
        row.addAttribute("action","select");
        row.add(new BaseElement("funcode").addText("101201"));
        row.add(new BaseElement("yid").addText(StringUtil.trim(questionnaire.getYid())));
        row.add(new BaseElement("patname").addText(StringUtil.trim(questionnaire.getPatName())));
        row.add(new BaseElement("idcard").addText(StringUtil.trim(questionnaire.getIdCard())));
        if (StringUtil.isEmpty(questionnaire.getIdCard())){
            row.add(new BaseElement("mobileno").addText(StringUtil.trim(questionnaire.getMobileNo())));
        }else{
            row.add(new BaseElement("mobileno").addText(""));
        }
//        row.add(new BaseElement("visitcardno").addText(StringUtil.trim(questionnaire.getVisitCardNo())));
        row.add(new BaseElement("visitcardno").addText(""));
        row.add(new BaseElement("followupname").addText(StringUtil.trim(questionnaire.getFollowupName())));
        row.add(new BaseElement("followuptype").addText(StringUtil.trim(questionnaire.getFollowupType())));
        row.add(new BaseElement("msgtype").addText(StringUtil.trim(questionnaire.getMsgType())));
        row.add(new BaseElement("followuptime").addText(StringUtil.trim(questionnaire.getFollowupTime())));
        row.add(new BaseElement("title").addText(StringUtil.trim(questionnaire.getTitle())));
        row.add(new BaseElement("msgurl").addText(StringUtil.trim(questionnaire.getMsgUrl())));
        row.add(new BaseElement("deptName").addText(StringUtil.trim(questionnaire.getDeptName())));
        msg.addCDATA(document1.asXML());
        return document.asXML();
    }
}
