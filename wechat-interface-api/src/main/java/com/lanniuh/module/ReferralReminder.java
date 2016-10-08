package com.lanniuh.module;

import java.io.Serializable;

/**
 * Created by linjian
 * 16/8/26.
 */
public class ReferralReminder implements Serializable {
    private static final long serialVersionUID = 7829952894187412940L;
    private String hospCode;//医院编码
    private String patName;//患者姓名
    private String idCard;//身份证
    private String mobileNo;//手机号
    private String visitCardNo;//就诊卡号
    private String visitCardType;//就诊卡类型 1-门诊 2-住院
    private String followupName;//医护人员姓名
    private String followupType;//医护人员类别（1医生  2护士）
    private String followupTime;//复诊时间
    private String address;//复诊地址
    private String content;//复诊内容

    public ReferralReminder() {
    }

    public ReferralReminder(String hospCode, String patName, String idCard, String mobileNo, String visitCardNo, String visitCardType, String followupName, String followupType, String followupTime, String address, String content) {
        this.hospCode = hospCode;
        this.patName = patName;
        this.idCard = idCard;
        this.mobileNo = mobileNo;
        this.visitCardNo = visitCardNo;
        this.visitCardType = visitCardType;
        this.followupName = followupName;
        this.followupType = followupType;
        this.followupTime = followupTime;
        this.address = address;
        this.content = content;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode;
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

    public String getFollowupTime() {
        return followupTime;
    }

    public void setFollowupTime(String followupTime) {
        this.followupTime = followupTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
