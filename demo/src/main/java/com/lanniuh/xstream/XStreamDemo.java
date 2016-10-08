package com.lanniuh.xstream;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjian
 * 16/9/3.
 */
public class XStreamDemo {


    public static void main(String[] args) {
//        bean2XML();
        list2XML();
    }

    /**
     * java对象转XML字符串
     */
    public static void bean2XML() {
        XStream xStream = new XStream();
        Student student = new Student(1, "林剑", "linjian_19886@163.com", "ZheJiang", "1988-10-26");
        xStream.alias("account", Student.class);
        xStream.aliasField("姓名",Student.class,"name");
        System.out.println(xStream.toXML(student));
    }

    /**
     * 将Java的List集合转换成XML对象
     */
    public static void list2XML(){
        XStream xStream = new XStream();
        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student(1, "林剑", "linjian@163.com", "ZheJiang", "1988-10-26");
        Student student2 = new Student(2, "张三", "zhangsan@163.com", "ZheJiang", "1990-01-21");
        studentList.add(student);
        studentList.add(student2);
        xStream.alias("studentList",List.class);
        xStream.alias("student",Student.class);
        //设置reference模型
        xStream.setMode(XStream.NO_REFERENCES);//不引用
//        xStream.setMode(XStream.ID_REFERENCES);//id引用
        System.out.println(xStream.toXML(studentList));
    }
}

class Student {
    private int id;
    private String name;
    private String email;
    private String address;
    private String birthday;

    public Student() {

    }

    public Student(int id, String name, String email, String address, String birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}