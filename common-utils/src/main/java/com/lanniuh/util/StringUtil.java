package com.lanniuh.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by linjian
 * 16/8/8.
 */
public class StringUtil {
    /**
     * 去null值
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        return str == null || "".equals(str) ? "" : str;
    }


    /**
     * 将byte数组转化成String
     *
     * @param bytes
     * @return
     */
    public static String bytes2String(byte[] bytes) {
        if (null == bytes || bytes.length == 0) {
            return "";
        }
        String sendString = null;
        try {
            sendString = new String(bytes, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("unsupported ISO-8859-1 encoding", e);
        }
        return sendString;
    }

    /**
     * 将string转化成byte[]
     *
     * @param str
     * @return
     */
    public static byte[] string2Bytes(String str) {
        if (null == str) {
            return null;
        }
        byte[] bytes;
        try {
            bytes = str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("unsupported ISO-8859-1 encoding", e);
        }
        return bytes;
    }

    /**
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符串转Double
     *
     * @param str
     * @return
     */
    public static Double StringToDouble(String str) {
        if (str == null) {
            return 0.0;
        } else {
            return Double.parseDouble(str);
        }
    }

    /**
     * 字符串数值相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String StringAdd(String num1, String num2) {
        if (num1 == null || "".equals(num1.trim()))
            num1 = "0.0";
        if (num2 == null || "".equals(num2.trim()))
            num2 = "0.0";
        BigDecimal bd1 = new BigDecimal(num1.trim());
        BigDecimal bd2 = new BigDecimal(num2.trim());
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        Double d = bd1.add(bd2).doubleValue();
        return d == 0 ? null : String.valueOf(nf.format(d));
    }

    /**
     * Double型字符串去除多余小数0
     *
     * @param str
     * @return
     */
    public static String StringTrun(String str) {
        if (str == null || "".equals(str.trim())) {
            str = "0.0";
        }
        Double d = (new BigDecimal(str.trim())).doubleValue();
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return d == 0 ? null : String.valueOf(nf.format(d));
    }

    /**
     * String 转化Calendar
     *
     * @param str
     * @return
     */
    public static Calendar str2Calendar(String str) {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(str);
            calendar.setTime(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * 判断字符串是否为空，或者为null
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }
}
