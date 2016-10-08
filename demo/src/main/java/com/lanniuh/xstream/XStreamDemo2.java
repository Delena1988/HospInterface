package com.lanniuh.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * XStream 注解方式
 * Created by linjian
 * 16/9/3.
 */
public class XStreamDemo2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Lin");
        person.setLastName("Jian");

        PhoneNumber tel = new PhoneNumber();
        tel.setCode(137280);
        tel.setNumber("137280968");

        PhoneNumber fax = new PhoneNumber();
        fax.setCode(20);
        fax.setNumber("020221327");
        person.setTel(tel);
        person.setFax(fax);

        List<String> friendList = new ArrayList<String>();
        friendList.add("A1");
        friendList.add("A2");
        friendList.add("A3");
        Friends friend1 = new Friends();
        friend1.setName(friendList);
        person.setFriend(friend1);

        System.out.println(toXml(person));
    }

    public static String toXml(Object obj) {
        XStream xstream = new XStream();
        //直接用jaxp dom来解释
//        XStream xstream = new XStream(new DomDriver());
        //指定编码解析器,直接用jaxp dom来解释
//        XStream xstream = new XStream(new DomDriver("utf-8"));
        //如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
        xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话
        return xstream.toXML(obj);
    }
}

@XStreamAlias("person")
class Person {
    @XStreamAlias("firstName")
    private String firstName;
    @XStreamAlias("lastName")
    private String lastName;
    @XStreamAlias("telephone")
    private PhoneNumber tel;
    @XStreamAlias("faxphone")
    private PhoneNumber fax;
    @XStreamAlias("friends")
    private Friends friend;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PhoneNumber getTel() {
        return tel;
    }

    public void setTel(PhoneNumber tel) {
        this.tel = tel;
    }

    public PhoneNumber getFax() {
        return fax;
    }

    public void setFax(PhoneNumber fax) {
        this.fax = fax;
    }

    public Friends getFriend() {
        return friend;
    }

    public void setFriend(Friends friend) {
        this.friend = friend;
    }
}

class PhoneNumber {
    private int code;
    private String number;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

class Friends {
    private List<String> name;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}

