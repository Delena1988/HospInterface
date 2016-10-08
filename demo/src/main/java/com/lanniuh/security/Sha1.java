package com.lanniuh.security;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by linjian
 * 16/8/24.
 */
public class Sha1 {
    public static String encryptBySha1(String str) throws DigestException {
        try {
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            //获取字节数组
            byte[] messageDigest = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            int length = messageDigest.length;
            for (int i = 0; i < length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new DigestException("签名错误！");
        }
    }

    public static void main(String[] args) throws DigestException {
        String str = "hospitalId=100201&method=getNoPayVisitInfo001&nonceStr=12345678&openId=123456&key=6BB30AAE2804144011040E664D87AC5452246969";
        System.out.println(Sha1.encryptBySha1(str));

        System.out.println(DigestUtils.shaHex(str).toUpperCase());
    }
    
}
