package com.springBootBasic.pojo;

import org.apache.catalina.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/8 0008
 */
public class Student implements Serializable{

    private String xh;
    private String xm;
    private String mm;
    private String bj;
    private String sfzh;
    private String qq;
    private String mobile;
    private String email;

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm;
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "xh='" + xh + '\'' +
                ", xm='" + xm + '\'' +
                ", mm='" + mm + '\'' +
                ", bj='" + bj + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", qq='" + qq + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

//    public static List toObject(List<Map> list){
//        List students=new ArrayList();
//        for(Map map:list){
//            Student student=toObject(map);
//            if(student != null){
//                students.add(student);
//            }
//        }
//        return students;
//    }
//
//    public static Student toObject(Map map){
//        Student student=new Student();
//        student.setXh((String) map.get("xh"));
//        student.setXm((String) map.get("xm"));
//        student.setMm((String) map.get("mm"));
//        student.setBj((String) map.get("bj"));
//        student.setSfzh((String) map.get("sfzh"));
//        student.setQq((String) map.get("qq"));
//        student.setMobile((String) map.get("email"));
//        student.setEmail((String)map.get("email"));
//        return student;
//    }

    public static Student toObject(List<String> list){
        Student student=new Student();
        student.setXh(list.get(0));
        student.setXm(list.get(1));
        student.setMm(list.get(2));
        student.setBj(list.get(3));
        student.setSfzh(list.get(4));
        student.setQq(list.get(5));
        student.setMobile(list.get(6));
        student.setEmail(list.get(7));
        return student;
    }

    public static List toObjecet(Student student){
        List<String> list=new ArrayList<String>();
        list.add(student.getXh());
        list.add(student.getXm());
        list.add(student.getMm());
        list.add(student.getBj());
        list.add(student.getSfzh());
        list.add(student.getQq());
        list.add(student.getMobile());
        list.add(student.getEmail());
        return list;
    }
}
