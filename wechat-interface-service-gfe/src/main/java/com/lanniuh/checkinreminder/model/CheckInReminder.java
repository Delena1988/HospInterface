package com.lanniuh.checkinreminder.model;

import java.util.Date;

public class CheckInReminder {
    private Integer id;

    private String patientId;

    private String username;

    private String userSex;

    private String userIdcard;

    private Date birthDate;

    private String age;

    private String healthNum;

    private Date registrationTime;

    private String registrationOffice;

    private String registrationSerial;

    private String registrationDoctor;

    private Date appointmentTime;

    private String queueNumberType;

    private String queueNumber;

    private Date treatmentDate;

    private String visitTimeDesc;

    private String bdFlag;

    private String bdTime;

    private Integer isYf;

    private Integer isBrq;

    private String modeType;

    private String address;

    private Date checkTime;

    private Double weight;

    private Double height;

    private Double temperature;

    private Double systolicPressure;

    private Double diastolicPressure;

    private Double pulse;

    private Double respiratoryRate;

    private Double headCircumference;

    private Double fontanelSize;

    private Double gestationalWeeks;

    private Double analysis;

    private Double abdominalCircumference;

    private Double fetalHeartRate;

    private Integer recordId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getHealthNum() {
        return healthNum;
    }

    public void setHealthNum(String healthNum) {
        this.healthNum = healthNum == null ? null : healthNum.trim();
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getRegistrationOffice() {
        return registrationOffice;
    }

    public void setRegistrationOffice(String registrationOffice) {
        this.registrationOffice = registrationOffice == null ? null : registrationOffice.trim();
    }

    public String getRegistrationSerial() {
        return registrationSerial;
    }

    public void setRegistrationSerial(String registrationSerial) {
        this.registrationSerial = registrationSerial == null ? null : registrationSerial.trim();
    }

    public String getRegistrationDoctor() {
        return registrationDoctor;
    }

    public void setRegistrationDoctor(String registrationDoctor) {
        this.registrationDoctor = registrationDoctor == null ? null : registrationDoctor.trim();
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getQueueNumberType() {
        return queueNumberType;
    }

    public void setQueueNumberType(String queueNumberType) {
        this.queueNumberType = queueNumberType == null ? null : queueNumberType.trim();
    }

    public String getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber == null ? null : queueNumber.trim();
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getVisitTimeDesc() {
        return visitTimeDesc;
    }

    public void setVisitTimeDesc(String visitTimeDesc) {
        this.visitTimeDesc = visitTimeDesc == null ? null : visitTimeDesc.trim();
    }

    public String getBdFlag() {
        return bdFlag;
    }

    public void setBdFlag(String bdFlag) {
        this.bdFlag = bdFlag == null ? null : bdFlag.trim();
    }

    public String getBdTime() {
        return bdTime;
    }

    public void setBdTime(String bdTime) {
        this.bdTime = bdTime == null ? null : bdTime.trim();
    }

    public Integer getIsYf() {
        return isYf;
    }

    public void setIsYf(Integer isYf) {
        this.isYf = isYf;
    }

    public Integer getIsBrq() {
        return isBrq;
    }

    public void setIsBrq(Integer isBrq) {
        this.isBrq = isBrq;
    }

    public String getModeType() {
        return modeType;
    }

    public void setModeType(String modeType) {
        this.modeType = modeType == null ? null : modeType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(Double systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public Double getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(Double diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public Double getPulse() {
        return pulse;
    }

    public void setPulse(Double pulse) {
        this.pulse = pulse;
    }

    public Double getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(Double respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public Double getHeadCircumference() {
        return headCircumference;
    }

    public void setHeadCircumference(Double headCircumference) {
        this.headCircumference = headCircumference;
    }

    public Double getFontanelSize() {
        return fontanelSize;
    }

    public void setFontanelSize(Double fontanelSize) {
        this.fontanelSize = fontanelSize;
    }

    public Double getGestationalWeeks() {
        return gestationalWeeks;
    }

    public void setGestationalWeeks(Double gestationalWeeks) {
        this.gestationalWeeks = gestationalWeeks;
    }

    public Double getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Double analysis) {
        this.analysis = analysis;
    }

    public Double getAbdominalCircumference() {
        return abdominalCircumference;
    }

    public void setAbdominalCircumference(Double abdominalCircumference) {
        this.abdominalCircumference = abdominalCircumference;
    }

    public Double getFetalHeartRate() {
        return fetalHeartRate;
    }

    public void setFetalHeartRate(Double fetalHeartRate) {
        this.fetalHeartRate = fetalHeartRate;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @Override
    public String toString() {
        return "CheckInReminder{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", username='" + username + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userIdcard='" + userIdcard + '\'' +
                ", birthDate=" + birthDate +
                ", age='" + age + '\'' +
                ", healthNum='" + healthNum + '\'' +
                ", registrationTime=" + registrationTime +
                ", registrationOffice='" + registrationOffice + '\'' +
                ", registrationSerial='" + registrationSerial + '\'' +
                ", registrationDoctor='" + registrationDoctor + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", queueNumberType='" + queueNumberType + '\'' +
                ", queueNumber='" + queueNumber + '\'' +
                ", treatmentDate=" + treatmentDate +
                ", visitTimeDesc='" + visitTimeDesc + '\'' +
                ", bdFlag='" + bdFlag + '\'' +
                ", bdTime='" + bdTime + '\'' +
                ", isYf=" + isYf +
                ", isBrq=" + isBrq +
                ", modeType='" + modeType + '\'' +
                ", address='" + address + '\'' +
                ", checkTime=" + checkTime +
                ", weight=" + weight +
                ", height=" + height +
                ", temperature=" + temperature +
                ", systolicPressure=" + systolicPressure +
                ", diastolicPressure=" + diastolicPressure +
                ", pulse=" + pulse +
                ", respiratoryRate=" + respiratoryRate +
                ", headCircumference=" + headCircumference +
                ", fontanelSize=" + fontanelSize +
                ", gestationalWeeks=" + gestationalWeeks +
                ", analysis=" + analysis +
                ", abdominalCircumference=" + abdominalCircumference +
                ", fetalHeartRate=" + fetalHeartRate +
                ", recordId=" + recordId +
                '}';
    }
}