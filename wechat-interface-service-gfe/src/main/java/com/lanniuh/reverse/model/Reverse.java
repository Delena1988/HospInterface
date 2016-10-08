package com.lanniuh.reverse.model;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by linjian
 * 16/9/13.
 */
@Component
public class Reverse {
    private String organCode;
    private String patName;
    private String idNumber;
    private String mobileNo;
    private String visitCardNo;
    private Date reverseDate;
    private Date visitDate;
    private String deptCode;
    private String deptName;

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public Date getReverseDate() {
        return reverseDate;
    }

    public void setReverseDate(Date reverseDate) {
        this.reverseDate = reverseDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Reverse{" +
                "organCode='" + organCode + '\'' +
                ", patName='" + patName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", visitCardNo='" + visitCardNo + '\'' +
                ", reverseDate=" + reverseDate +
                ", visitDate=" + visitDate +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
