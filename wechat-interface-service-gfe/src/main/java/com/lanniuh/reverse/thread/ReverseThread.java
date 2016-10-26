package com.lanniuh.reverse.thread;

import com.alibaba.fastjson.JSON;
import com.lanniuh.reverse.handle.ReverseHandle;
import com.lanniuh.reverse.model.Reverse;
import com.lanniuh.reverse.service.ReverseService;
import com.lanniuh.reverserecord.model.ReverseRecord;
import com.lanniuh.reverserecord.service.ReverseRecordService;
import com.lanniuh.util.*;
import com.lanniuh.webservice.WeChatWebservice;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.*;

import static com.lanniuh.util.SpringContextUtil.getBean;

/**
 * Created by linjian
 * 16/9/13.
 */
public class ReverseThread extends Thread {
    Logger logger = Logger.getLogger(ReverseThread.class);
    private List<Reverse> reverses;
    private List<String> pregnantDeptList;
    private List<String> childDeptList;
    private List<String> reproductionList;

    public ReverseThread(List<Reverse> reverses) {
        this.reverses = reverses;
        pregnantDeptList = Arrays.asList(PropertiesUtil.getInstanse().getPregnantDept().split(","));
        childDeptList = Arrays.asList(PropertiesUtil.getInstanse().getChildDept().split(","));
        reproductionList = Arrays.asList(PropertiesUtil.getInstanse().getReproductionDept().split(","));
    }

    @Override
    public void run() {
        for (Reverse reverse : reverses) {
            invokeInterface(reverse);
        }
    }

    //invoke interface
    public  void invokeInterface(Reverse reverse) {
        System.out.println("reverse: " + reverse.toString());
        //调用平台接口判断是不是首诊，是否需要建档
        ReverseService reverseService = getBean("reverseService");
        int filingFlag = 0;
        filingFlag = reverseService.firstVisit(reverse);//0未建档  1已建档
        System.out.println("filing flag: " + filingFlag);
        String url = "";
        String msgType = "";
        String returnCode = "";
        String returnMsg = "";

        if (filingFlag == 0 ) {
            //需要建档
            if (pregnantDeptList.contains(reverse.getDeptCode())) {//孕产妇建档
                url = getPregnantFilingUrl(reverse);
                logger.info("pregnant url: " + url);
            }
            else if (childDeptList.contains(reverse.getDeptCode())) {//儿童早发建档
                url = getChildFilingUrl(reverse);
                logger.info("child url: " + url);
            }
            else if(reproductionList.contains(reverse.getDeptCode())){//生殖医学中心建档
                if ("1".equals(reverse.getSexCode()) || "1".equals(IDCardUtil.getSex(reverse.getIdNumber()))){
                    url = getReproductionMaleFilingUrl(reverse);
                    logger.info("reproduction male url: " + url);
                }
                else if("2".equals(reverse.getSexCode()) || "2".equals(IDCardUtil.getSex(reverse.getIdNumber()))){
                    url = getReproductionFemaleFilingUrl(reverse);
                    logger.info("reproduction femal url: " + url);
                }else{
                    logger.info("reproduction cannot tell sex!!!");
                }
            }
            if (!StringUtil.isEmpty(url)){
                //推送建档消息，先推微信模版，失败的话发送短信
                String result = sendMsg2WeChat(reverse, url);
                msgType = "weChat";
                if ("-1".equals(result)) {
                    returnCode = "-1";
                    returnMsg = "invoke weChat h5 webservice failed";
                } else {
                    Document document = XmlUtil.str2Doc(result);
                    Element root = document.getRootElement();
                    returnCode = root.selectSingleNode("//returnCode").getText();
                    returnMsg = root.selectSingleNode("//returnMsg").getText();
                }
                if (!"0".equals(returnCode)) {
                    //微信发送失败，发送短信
                    result = sendShortMsg(reverse, url);
                    msgType = "shortMsg";
                    if ("-1".equals(result)) {
                        returnCode = "-1";
                        returnMsg = "invoke weChat short msg webservice failed";
                    } else {
                        Document document = XmlUtil.str2Doc(result);
                        Element root = document.getRootElement();
                        returnCode = root.selectSingleNode("//returnCode").getText();
                        returnMsg = root.selectSingleNode("//returnMsg").getText();
                    }
                }
            }else{
                url = "get url from interview error";
            }
        }

        //save record
        ReverseRecordService reverseRecordService = SpringContextUtil.getBean("reverseRecordService");
        ReverseRecord reverseRecord = new ReverseRecord();
        reverseRecord.setId(UUID.randomUUID().toString().replace("-",""));
        reverseRecord.setPatName(reverse.getPatName());
        reverseRecord.setIdNumber(reverse.getIdNumber());
        reverseRecord.setMobileNo(reverse.getMobileNo());
        reverseRecord.setVisitCardNo(reverse.getVisitCardNo());
        reverseRecord.setReverseDate(reverse.getReverseDate());
        reverseRecord.setVisitDate(reverse.getVisitDate());
        reverseRecord.setDeptCode(reverse.getDeptCode());
        reverseRecord.setDeptName(reverse.getDeptName());
        reverseRecord.setFilingFlag(filingFlag);
        reverseRecord.setPushTime(new Date());
        reverseRecord.setUrl(url);
        reverseRecord.setMsgType(msgType);
        reverseRecord.setReturnCode(returnCode);
        reverseRecord.setReturnMsg(returnMsg);
        reverseRecordService.insert(reverseRecord);

    }

    //获取早发儿童自助建档url
    private String getChildFilingUrl(Reverse reverse){
        String url = PropertiesUtil.getInstanse().getInterviewFilingUrl();
        String serverCode = PropertiesUtil.getInstanse().getInterviewServerCode();
        String secret = PropertiesUtil.getInstanse().getInterviewKey();

        String protocol = "1001";//儿童早发自助建档
        Map<String,String> params = new HashMap<>();
        params.put("protocol",protocol);
        params.put("patName",reverse.getPatName());
        params.put("visitCardNo", reverse.getVisitCardNo());
        String res = HttpUtil.sendPost(serverCode,secret,url,params);
        return JSON.parseObject(res).getString("url");
    }

    //获取孕产妇自助建档
    private String getPregnantFilingUrl(Reverse reverse) {
        String url = PropertiesUtil.getInstanse().getInterviewFilingUrl();
        String serverCode = PropertiesUtil.getInstanse().getInterviewServerCode();
        String secret = PropertiesUtil.getInstanse().getInterviewKey();

        String protocol = "1002";//孕产妇自助建档
        Map<String, String> params = new HashMap<>();
        params.put("protocol", protocol);
        params.put("patName", reverse.getPatName());
        params.put("idCard", reverse.getIdNumber());
        String res = HttpUtil.sendPost(serverCode,secret,url,params);
        return JSON.parseObject(res).getString("url");
    }

    //获取生殖医学中心自助建档 男性
    private String getReproductionMaleFilingUrl(Reverse reverse){
        String url = PropertiesUtil.getInstanse().getInterviewFilingUrl();
        String serverCode = PropertiesUtil.getInstanse().getInterviewServerCode();
        String secret = PropertiesUtil.getInstanse().getInterviewKey();

        String protocol = "1003";//生殖医学中心自助建档 男性
        Map<String, String> params = new HashMap<>();
        params.put("protocol", protocol);
        params.put("patName", reverse.getPatName());
        params.put("idCard", reverse.getIdNumber());
        params.put("visitCardNo", reverse.getVisitCardNo());
        String res = HttpUtil.sendPost(serverCode, secret, url, params);
        return JSON.parseObject(res).getString("url");
    }

    //获取生殖医学中心自助建档 女性
    private String getReproductionFemaleFilingUrl(Reverse reverse) {
        String url = PropertiesUtil.getInstanse().getInterviewFilingUrl();
        String serverCode = PropertiesUtil.getInstanse().getInterviewServerCode();
        String secret = PropertiesUtil.getInstanse().getInterviewKey();

        String protocol = "1004";//生殖医学中心自助建档 女性
        Map<String, String> params = new HashMap<>();
        params.put("protocol", protocol);
        params.put("patName", reverse.getPatName());
        params.put("idCard", reverse.getIdNumber());
        params.put("visitCardNo", reverse.getVisitCardNo());
        String res = HttpUtil.sendPost(serverCode, secret, url, params);
        return JSON.parseObject(res).getString("url");
    }

    //发送建档h5给微信
    private String sendMsg2WeChat(Reverse reverse,String url){
        String reqXml = ReverseHandle.assemblyWeChatXmlReq(reverse, url);;

        String result = WeChatWebservice.invokeWeChatWebservice(reqXml);
        if (result == null){//调用微信接口失败
            return "-1";
        }else{
            return result;
        }
    }

    //通过调用微信接口发送建档短信
    private String sendShortMsg(Reverse reverse, String url) {
        String reqXml = ReverseHandle.assemblyShortXmlReq(reverse, url);

        String result = WeChatWebservice.invokeWeChatWebservice(reqXml);
        if (result == null) {//调用微信接口失败
            return "-1";
        } else {
            return result;
        }
    }


    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.setOrganCode("683292136");
        reverse.setPatName("林剑");
        reverse.setIdNumber("330225198810260359");
        reverse.setVisitCardNo("1000000171777");
        reverse.setDeptCode("20034");
//        reverse.setPatName("蔡玲玲");
//        reverse.setVisitCardNo("1000000190564");
//        reverse.setDeptCode("20034");

//        String reqXml = ReverseHandle.assemblyWeChatXmlReq(reverse, "www.lanniuh.com:9087/hug_interview/maternalFilingAction!toMaternalFiling.htm");
//
//        String result = WeChatWebservice.invokeWeChatWebservice(reqXml);
//        System.out.println(result);

//        String reqXml = ReverseHandle.assemblyShortXmlReq(reverse, "http://www.lanniuh.com/sf/yaEfIz");
//
//        String result = WeChatWebservice.invokeWeChatWebservice(reqXml);
//        System.out.println(result);


        //get url
        String url = PropertiesUtil.getInstanse().getInterviewFilingUrl();
        String serverCode = PropertiesUtil.getInstanse().getInterviewServerCode();
        String secret = PropertiesUtil.getInstanse().getInterviewKey();

        String protocol = "1002";//孕产妇自助建档
        Map<String, String> params = new HashMap<>();
        params.put("protocol", protocol);
        params.put("patName", reverse.getPatName());
        params.put("idCard", reverse.getIdNumber());
        String res = HttpUtil.sendPost(serverCode, secret, url, params);
        System.out.println(res);


//        String url = PropertiesUtil.getInstanse().getInterviewFilingUrl();
//        String serverCode = PropertiesUtil.getInstanse().getInterviewServerCode();
//        String secret = PropertiesUtil.getInstanse().getInterviewKey();
//
//        String protocol = "1001";//儿童早发自助建档
//        Map<String, String> params = new HashMap<>();
//        params.put("protocol", protocol);
//        params.put("patName", reverse.getPatName());
//        params.put("visitCardNo", reverse.getVisitCardNo());
//        String res = HttpUtil.sendPost(serverCode, secret, url, params);
//        System.out.println(res);
    }
}
