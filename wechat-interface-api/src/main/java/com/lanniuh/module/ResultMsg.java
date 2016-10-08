package com.lanniuh.module;

import java.io.Serializable;

/**
 * Created by linjian
 * 16/8/18.
 */
public class ResultMsg implements Serializable {
    private static final long serialVersionUID = -8181679582383226749L;
    private String code;//结果代码 0-成功 -1-失败
    private String msg;//结果描述

    public ResultMsg() {
    }

    public ResultMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
