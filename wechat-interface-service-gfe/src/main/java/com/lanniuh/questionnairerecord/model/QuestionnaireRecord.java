package com.lanniuh.questionnairerecord.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class QuestionnaireRecord{
    private String id;

    private String thirdCode;

    private String yid;

    private String patName;

    private String hospCode;

    private String idCard;

    private String mobileNo;

    private String cardNo;

    private String cardType;

    private String followupName;

    private String followupType;

    private String msgType;

    private Date followupTime;

    private String title;

    private String msgUrl;

    private String deptName;

    private String returnCode;

    private String returnMsg;

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
        this.thirdCode = thirdCode == null ? null : thirdCode.trim();
    }

    public String getYid() {
        return yid;
    }

    public void setYid(String yid) {
        this.yid = yid == null ? null : yid.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getHospCode() {
        return hospCode;
    }

    public void setHospCode(String hospCode) {
        this.hospCode = hospCode == null ? null : hospCode.trim();
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    public Date getFollowupTime() {
        return followupTime;
    }

    public void setFollowupTime(Date followupTime) {
        this.followupTime = followupTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl == null ? null : msgUrl.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }
}