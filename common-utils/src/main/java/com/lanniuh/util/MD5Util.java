package com.lanniuh.util;


import java.security.MessageDigest;
import java.util.UUID;

/**
 * Created by linjian
 * 16/9/1.
 */
public class MD5Util {
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String partnerId = "wx_gzfnetylzx";
        String key = "76a42dc029ef43b9bc8d56f3831015ed";
        long time = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(partnerId).append(time).append(key);
        String md5 = MD5Util.MD5(stringBuffer.toString());
        System.out.println("time: " + time);
        System.out.println("MD5: " + md5);
        String url = "http://121.40.185.58:3000/mobile/medical/patient/medicalRecord/query";
        String partnerType = "1001";
        String cardNo = "4401000002023348";
        String cardType = "1";
        String hospCode = "683292136";
        String patName = "何梓华";
        stringBuffer.delete(0,stringBuffer.length());
        stringBuffer.append(url).append("?")
                .append("partnerId=").append(partnerId)
                .append("&partnerType=").append(partnerType)
                .append("&time=").append(time)
                .append("&md5=").append(md5)
                .append("&cardNo=").append(cardNo)
                .append("&cardType=").append(cardType)
                .append("&hospCode=").append(hospCode)
                .append("&patName=").append(patName);
        System.out.println("url: " + stringBuffer.toString());

        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
