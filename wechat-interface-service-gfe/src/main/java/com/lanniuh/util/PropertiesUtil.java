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

    private static final String PATH = "config.properties";

    private static PropertiesUtil instanse = new PropertiesUtil();

    private Map<String, String> propertis;

    public static PropertiesUtil getInstanse() {
        return instanse;
    }

    public String getIp(){
        return propertis.get("ip");
    }
    public String getPort(){
        return  propertis.get("port");
    }
    public String getKey(){
        return propertis.get("key");
    }
    public String gethospitalId(){
        return propertis.get("hospitalId");
    }
    public String getOpenId(){
        return propertis.get("openId");
    }
    public String getChannel(){
        return propertis.get("channel");
    }
    public String getUrl(){
        return propertis.get("url");
    }
    public String getShortKey(){
        return propertis.get("shortKey");
    }
    public String getShortChannel(){
        return propertis.get("shortChannel");
    }
    public String getShortOpenId(){
        return propertis.get("shortOpenId");
    }
    public String getHeLeUrl(){
        return propertis.get("hele_url");
    }
    public String getInterviewFilingUrl(){
        return propertis.get("interview_filing_url");
    }
    public String getInterviewServerCode(){
        return propertis.get("interview_server_code");
    }
    public String getInterviewKey(){
      return  propertis.get("interview_http_key");
    }
    public String getFilingDept(){
        return propertis.get("filing_dept");
    }
    public String getPregnantDept(){
        return propertis.get("pregnant_dept");
    }
    public String getChildDept(){
        return propertis.get("child_dept");
    }
    public String getReproductionDept(){
        return propertis.get("reproduction_dept");
    }
    
    public String get(String param){
    	return propertis.get(param);
    }

    private PropertiesUtil() {
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(PATH);
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
