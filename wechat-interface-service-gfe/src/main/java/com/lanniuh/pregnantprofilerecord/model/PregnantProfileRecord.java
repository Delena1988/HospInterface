package com.lanniuh.pregnantprofilerecord.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PregnantProfileRecord {
    private String id;

    private Integer result;

    private String errormsg;

    private Date pushTime;

    private String req;

    private String selfpregnantinfos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getSelfpregnantinfos() {
        return selfpregnantinfos;
    }

    public void setSelfpregnantinfos(String selfpregnantinfos) {
        this.selfpregnantinfos = selfpregnantinfos == null ? null : selfpregnantinfos.trim();
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}