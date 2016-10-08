package com.lanniuh.pregnantprofile.token;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanniuh.util.HttpUtil;
import com.lanniuh.util.PropertiesUtil;
import org.apache.log4j.Logger;

/**
 * Created by linjian
 * 16/9/18.
 */
public class Token {
    Logger logger = Logger.getLogger(Token.class);
    private static String token;
    private static final Token TOKEN = new Token();

    private Token(){
    }

    public static Token getInstance() {
        return TOKEN;
    }

    public void resetToken(){
        String url = PropertiesUtil.getInstanse().getHeLeUrl();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appid","fezx");
        jsonObject.put("type","1001");
        String res = HttpUtil.sendPostHeLe(url, JSON.toJSONString(jsonObject));
        logger.info("resetToken: " + res);
        JSONObject json = JSON.parseObject(res);
        token = json.getString("token");
    }

    public static String getToken() {
        return token;
    }

    public static void main(String[] args) {
//        String url = PropertiesUtil.getInstanse().getHeLeUrl();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("appid", "fezx");
//        jsonObject.put("type", "1001");
//        String res = HttpUtil.sendGet(url, "s=" + JSON.toJSONString(jsonObject));
//        System.out.println("res: " +res);
        new Token().resetToken();
        System.out.println(token);
    }
}
