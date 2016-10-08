package com.lanniuh.checkinrecord.model;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class CheckInRecord {
    private String id;

    private String patName;

    private String visitCardNo;

    private Date checkInTime;

    private Date reminderTime;

    private String msgType;

    private String returnCode;

    private String returnMsg;

    public CheckInRecord() {
    }

    public CheckInRecord(String id, String patName, String visitCardNo, Date checkInTime, Date reminderTime, String msgType, String returnCode, String returnMsg) {
        this.id = id;
        this.patName = patName;
        this.visitCardNo = visitCardNo;
        this.checkInTime = checkInTime;
        this.reminderTime = reminderTime;
        this.msgType = msgType;
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getVisitCardNo() {
        return visitCardNo;
    }

    public void setVisitCardNo(String visitCardNo) {
        this.visitCardNo = visitCardNo == null ? null : visitCardNo.trim();
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
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

    @Override
    public String toString() {
        return "CheckInRecord{" +
                "id='" + id + '\'' +
                ", patName='" + patName + '\'' +
                ", visitCardNo='" + visitCardNo + '\'' +
                ", checkInTime=" + checkInTime +
                ", reminderTime=" + reminderTime +
                ", msgType='" + msgType + '\'' +
                ", returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                '}';
    }
}