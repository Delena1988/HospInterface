package com.lanniuh.referralreminderrecord.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class ReferralReminderRecord{
    private String id;

    private String thirdCode;

    private String hospCode;

    private String patName;

    private String idCard;

    private String mobileNo;

    private String visitCardNo;

    private String visitCardType;

    private String followupName;

    private String followupType;

    private String followupTime;

    private String address;

    private Date sentTime;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode == null ? null : hospCode.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public String getVisitCardNo() {
        return visitCardNo;
    }

    public void setVisitCardNo(String visitCardNo) {
        this.visitCardNo = visitCardNo == null ? null : visitCardNo.trim();
    }

    public String getVisitCardType() {
        return visitCardType;
    }

    public void setVisitCardType(String visitCardType) {
        this.visitCardType = visitCardType == null ? null : visitCardType.trim();
    }

    public String getFollowupName() {
        return followupName;
    }

    public void setFollowupName(String followupName) {
        this.followupName = followupName == null ? null : followupName.trim();
    }

    public String getFollowupType() {
        return followupType;
    }

    public void setFollowupType(String followupType) {
        this.followupType = followupType == null ? null : followupType.trim();
    }

    public String getFollowupTime() {
        return followupTime;
    }

    public void setFollowupTime(String followupTime) {
        this.followupTime = followupTime == null ? null : followupTime.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}