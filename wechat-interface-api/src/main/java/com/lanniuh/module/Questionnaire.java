package com.lanniuh.module;

import java.io.Serializable;

/**
 * Created by linjian
 * 16/8/18.
 */
public class Questionnaire implements Serializable {
    private static final long serialVersionUID = -862132711975523840L;
    private String yid;//随访宣教信息id
    private String hospCode;//医院编码
    private String patName;//患者姓名
    private String idCard;//身份证
    private String mobileNo;//手机号
    private String visitCardNo;//就诊卡号
    private String visitCardType;//就诊卡类型 1-门诊 2-住院
    private String followupName;//随访人员姓名
    private String followupType;//随访人员类别（1医生  2护士）
    private String msgType;//推送类别   1-随访提醒 6-出院宣教提醒 7-入院宣教提醒 12-其他宣教 99-复诊提醒
    private String followupTime;//随访时间
    private String title;//问卷或宣教的标题
    private String msgUrl;//问卷或宣教链接
    private String deptName;//科室名称
    private String typeId = "1";//广妇儿专用,默认值1

    public Questionnaire() {
    }

    public Questionnaire(String yid, String hospCode, String patName, String idCard, String mobileNo, String visitCardNo, String visitCardType, String followupName, String followupType, String msgType, String followupTime, String title, String msgUrl, String deptName, String typeId) {
        this.yid = yid;
        this.hospCode = hospCode;
        this.patName = patName;
        this.idCard = idCard;
        this.mobileNo = mobileNo;
        this.visitCardNo = visitCardNo;
        this.visitCardType = visitCardType;
        this.followupName = followupName;
        this.followupType = followupType;
        this.msgType = msgType;
        this.followupTime = followupTime;
        this.title = title;
        this.msgUrl = msgUrl;
        this.deptName = deptName;
        this.typeId = typeId;
    }

    public String getYid() {
        return yid;
    }

    public void setYid(String yid) {
        this.yid = yid;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getVisitCardNo() {
        return visitCardNo;
    }

    public void setVisitCardNo(String visitCardNo) {
        this.visitCardNo = visitCardNo;
    }

    public String getVisitCardType() {
        return visitCardType;
    }

    public void setVisitCardType(String visitCardType) {
        this.visitCardType = visitCardType;
    }

    public String getFollowupName() {
        return followupName;
    }

    public void setFollowupName(String followupName) {
        this.followupName = followupName;
    }

    public String getFollowupType() {
        return followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getFollowupTime() {
        return followupTime;
    }

    public void setFollowupTime(String followupTime) {
        this.followupTime = followupTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
    }
}
