package com.lanniuh.pregnantprofile.model;

/**
 * 和乐建档信息
 * Created by linjian
 * 16/9/21.
 */
public class SelfPregnantInfo {
    private int id;  //自增档案编号
    private String idcard;//身份证号
    private String personname;//姓名
    private String sexcode;//性别
    private String birthday;//生日
    private String bloodtypecode;//ABO 血型
    private String rhbloodcode;//Rh 血型
    private String mobilenumber;//手机号
    private String husbandname;//丈夫姓名
    private String homeaddress_text;//户籍地址/居住地址详情
    private String phonenumber;//家庭电话
    private String maritalstatuscode;//婚姻状况
    private String educationcode;//文化程度
    private String insurancecode;//保险类别
    private int menarcheage;//初潮年龄
    private int menstrualperiod;//经期
    private int cycle;//周期
    private String menstrualblood;//月经量
    private String dysmenorrhea;//痛经
    private String lastmenstrualperiod;//末次月经时间
    private String dateofprenatal;//预产期
    private String gravidity;//孕次
    private String parity;//产次
    private String unusualbone;//异常孕产史
    private int trafficflow;//人工流产次数
    private int naturalabortion;//自然流产次数
    private int qwetimes;//药物流产次数
    private int odinopoeia;//中期流产次数
    private int ectopicpregnancy;//宫外孕次数
    private int vesicularmole;//葡萄胎次数
    private String pregestationdate;//前次妊娠终止日(28 周前)
    private String pregestationmode;//终止方式
    private int preterm;//早产次数
    private int dystocia;//难产次数
    private int died;//死胎死产次数
    private int abnormality;//畸形儿次数
    private int newbrondied;//死亡儿次数
    private String predeliverydate;//前次分娩日期
    private String predeliverymode;//分娩方式
    private String gestationneuropathy;//妊娠并发症史
    private String husbandfamilyhistory;//丈夫家族史
    private String pasthistory;//既往病史
    private String familyhistory;//家族史
    private String operationhistory;//手术史
    private String gynecologyops;//妇科手术史
    private String allergichistory;//过敏史
    private String poisontouchhis;//毒物接触史
    private String heredityfamilyhistory;//遗传家族史
    private String folicsupplementation;//是否补充叶酸
    private String createtime;//
    private String updatetime;//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname.replace(" ","");
    }

    public String getSexcode() {
        return sexcode;
    }

    public void setSexcode(String sexcode) {
        this.sexcode = sexcode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBloodtypecode() {
        return bloodtypecode;
    }

    public void setBloodtypecode(String bloodtypecode) {
        this.bloodtypecode = bloodtypecode;
    }

    public String getRhbloodcode() {
        return rhbloodcode;
    }

    public void setRhbloodcode(String rhbloodcode) {
        this.rhbloodcode = rhbloodcode;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getHusbandname() {
        return husbandname;
    }

    public void setHusbandname(String husbandname) {
        this.husbandname = husbandname;
    }

    public String getHomeaddress_text() {
        return homeaddress_text;
    }

    public void setHomeaddress_text(String homeaddress_text) {
        this.homeaddress_text = homeaddress_text;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMaritalstatuscode() {
        return maritalstatuscode;
    }

    public void setMaritalstatuscode(String maritalstatuscode) {
        this.maritalstatuscode = maritalstatuscode;
    }

    public String getEducationcode() {
        return educationcode;
    }

    public void setEducationcode(String educationcode) {
        this.educationcode = educationcode;
    }

    public String getInsurancecode() {
        return insurancecode;
    }

    public void setInsurancecode(String insurancecode) {
        this.insurancecode = insurancecode;
    }

    public int getMenarcheage() {
        return menarcheage;
    }

    public void setMenarcheage(int menarcheage) {
        this.menarcheage = menarcheage;
    }

    public int getMenstrualperiod() {
        return menstrualperiod;
    }

    public void setMenstrualperiod(int menstrualperiod) {
        this.menstrualperiod = menstrualperiod;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getMenstrualblood() {
        return menstrualblood;
    }

    public void setMenstrualblood(String menstrualblood) {
        this.menstrualblood = menstrualblood;
    }

    public String getDysmenorrhea() {
        return dysmenorrhea;
    }

    public void setDysmenorrhea(String dysmenorrhea) {
        this.dysmenorrhea = dysmenorrhea;
    }

    public String getLastmenstrualperiod() {
        return lastmenstrualperiod;
    }

    public void setLastmenstrualperiod(String lastmenstrualperiod) {
        this.lastmenstrualperiod = lastmenstrualperiod;
    }

    public String getDateofprenatal() {
        return dateofprenatal;
    }

    public void setDateofprenatal(String dateofprenatal) {
        this.dateofprenatal = dateofprenatal;
    }

    public String getGravidity() {
        return gravidity;
    }

    public void setGravidity(String gravidity) {
        this.gravidity = gravidity;
    }

    public String getParity() {
        return parity;
    }

    public void setParity(String parity) {
        this.parity = parity;
    }

    public String getUnusualbone() {
        return unusualbone;
    }

    public void setUnusualbone(String unusualbone) {
        this.unusualbone = unusualbone;
    }

    public int getTrafficflow() {
        return trafficflow;
    }

    public void setTrafficflow(int trafficflow) {
        this.trafficflow = trafficflow;
    }

    public int getNaturalabortion() {
        return naturalabortion;
    }

    public void setNaturalabortion(int naturalabortion) {
        this.naturalabortion = naturalabortion;
    }

    public int getQwetimes() {
        return qwetimes;
    }

    public void setQwetimes(int qwetimes) {
        this.qwetimes = qwetimes;
    }

    public int getOdinopoeia() {
        return odinopoeia;
    }

    public void setOdinopoeia(int odinopoeia) {
        this.odinopoeia = odinopoeia;
    }

    public int getEctopicpregnancy() {
        return ectopicpregnancy;
    }

    public void setEctopicpregnancy(int ectopicpregnancy) {
        this.ectopicpregnancy = ectopicpregnancy;
    }

    public int getVesicularmole() {
        return vesicularmole;
    }

    public void setVesicularmole(int vesicularmole) {
        this.vesicularmole = vesicularmole;
    }

    public String getPregestationdate() {
        return pregestationdate;
    }

    public void setPregestationdate(String pregestationdate) {
        this.pregestationdate = pregestationdate;
    }

    public String getPregestationmode() {
        return pregestationmode;
    }

    public void setPregestationmode(String pregestationmode) {
        this.pregestationmode = pregestationmode;
    }

    public int getPreterm() {
        return preterm;
    }

    public void setPreterm(int preterm) {
        this.preterm = preterm;
    }

    public int getDystocia() {
        return dystocia;
    }

    public void setDystocia(int dystocia) {
        this.dystocia = dystocia;
    }

    public int getDied() {
        return died;
    }

    public void setDied(int died) {
        this.died = died;
    }

    public int getAbnormality() {
        return abnormality;
    }

    public void setAbnormality(int abnormality) {
        this.abnormality = abnormality;
    }

    public int getNewbrondied() {
        return newbrondied;
    }

    public void setNewbrondied(int newbrondied) {
        this.newbrondied = newbrondied;
    }

    public String getPredeliverydate() {
        return predeliverydate;
    }

    public void setPredeliverydate(String predeliverydate) {
        this.predeliverydate = predeliverydate;
    }

    public String getPredeliverymode() {
        return predeliverymode;
    }

    public void setPredeliverymode(String predeliverymode) {
        this.predeliverymode = predeliverymode;
    }

    public String getGestationneuropathy() {
        return gestationneuropathy;
    }

    public void setGestationneuropathy(String gestationneuropathy) {
        this.gestationneuropathy = gestationneuropathy;
    }

    public String getHusbandfamilyhistory() {
        return husbandfamilyhistory;
    }

    public void setHusbandfamilyhistory(String husbandfamilyhistory) {
        this.husbandfamilyhistory = husbandfamilyhistory;
    }

    public String getPasthistory() {
        return pasthistory;
    }

    public void setPasthistory(String pasthistory) {
        this.pasthistory = pasthistory;
    }

    public String getFamilyhistory() {
        return familyhistory;
    }

    public void setFamilyhistory(String familyhistory) {
        this.familyhistory = familyhistory;
    }

    public String getOperationhistory() {
        return operationhistory;
    }

    public void setOperationhistory(String operationhistory) {
        this.operationhistory = operationhistory;
    }

    public String getGynecologyops() {
        return gynecologyops;
    }

    public void setGynecologyops(String gynecologyops) {
        this.gynecologyops = gynecologyops;
    }

    public String getAllergichistory() {
        return allergichistory;
    }

    public void setAllergichistory(String allergichistory) {
        this.allergichistory = allergichistory;
    }

    public String getPoisontouchhis() {
        return poisontouchhis;
    }

    public void setPoisontouchhis(String poisontouchhis) {
        this.poisontouchhis = poisontouchhis;
    }

    public String getHeredityfamilyhistory() {
        return heredityfamilyhistory;
    }

    public void setHeredityfamilyhistory(String heredityfamilyhistory) {
        this.heredityfamilyhistory = heredityfamilyhistory;
    }

    public String getFolicsupplementation() {
        return folicsupplementation;
    }

    public void setFolicsupplementation(String folicsupplementation) {
        this.folicsupplementation = folicsupplementation;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
