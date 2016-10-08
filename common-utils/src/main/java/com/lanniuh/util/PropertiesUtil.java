package com.lanniuh.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 读取Properties文件的工具类
 *
 * @author chenjialong
 * @date Aug 3, 2012
 */
public class PropertiesUtil {
    public static void main(String[] args) {
        System.out.println(getInstanse().getPhoneUrl());
    }

    public String getFriendClear() {
        return this.propertis.get("friend_clear");
    }


    public String getMedicalClear() {
        return this.propertis.get("medical_clear");
    }

    public String getInterviewUrl() {
        return this.propertis.get("huginterface_server_url_interview");
    }

    /**
     * 后台管理的code
     *
     * @return
     */
    public String getManagerCode() {
        return this.propertis.get("manager_code");
    }

    /**
     * 后台管理的key
     *
     * @return
     */
    public String getManagerKey() {
        return this.propertis.get("manager_key");
    }

    /**
     * 侦听申请审核的手机号码
     *
     * @return
     */
    public String getPhoneForListen() {
        return this.propertis.get("phone_for_listen");
    }

    public String getSendVoip() {
        return this.propertis.get("system_send_voip");
    }

    /**
     * 获取远程地址
     *
     * @return
     */
    public String getServerUrl() {
        return this.propertis.get("huginterface_server_url_route");
    }

    /**
     * 服务编码
     *
     * @return
     */
    public String getServerCode() {
        return propertis.get("server_code");
    }

    /**
     * 获取服务器通讯的key
     */
    public String getHttpKey() {
        return propertis.get("http_key");
    }

    /**
     * AES密钥
     *
     * @return
     */
    public String getAesKey() {
        return propertis.get("AES_KEY");
    }

    /**
     * 获取文件根路径
     *
     * @return
     */
    public String getFileRoot() {
        return propertis.get("file_root");
    }

    public String getPushServerUrl() {
        return propertis.get("huginterface_server_url_push");
    }

    public String getQuestionnaireImageUrl() {
        return propertis.get("huginterface_image");
    }

    public boolean ysNeedRegist() {
        String value = propertis.get("ys_regist");
        return "true".equals(value);
    }

    public String getPhoneUrl() {
        return propertis.get("huginterface_server_url_phone");
    }

    public String getSmsUrl() {
        return propertis.get("huginterface_server_url_sms");
    }

    public String getPayAppKey() {
        return propertis.get("appKey");
    }

    public String getPayApiKey() {
        return propertis.get("apiKey");
    }

    private static final String PATH = "server/server.properties";

    private static PropertiesUtil instanse = new PropertiesUtil();

    private Map<String, String> propertis;

    public static PropertiesUtil getInstanse() {
        return instanse;
    }

    private PropertiesUtil() {
        InputStream is = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream(PATH);
        propertis = new HashMap<String, String>();
        if (null == is) {
            return;
        }

        Properties props = new Properties();

        try {
            props.load(is);
            Set<Object> set = props.keySet();
            Iterator<Object> it = set.iterator();

            while (it.hasNext()) {
                String key = it.next().toString();
                Object value = props.get(key);
                String val = "";
                if (null != value) {
                    val = new String(value.toString().getBytes("ISO-8859-1"),
                            "UTF-8");
                    val = val.trim();
                }
                propertis.put(key, val);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
