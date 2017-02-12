package com.springBootBasic.test;

import com.springBootBasic.pojo.Student;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/9 0009
 */
public class TestDemo {

    public static void main(String[] args){
        String Str="http://www.haier.com.dadawdaddasdadhttphttp://www.haier.com";
        Str=Str.replaceFirst("http://www.haier.com","http://image.haier.com");
        System.out.println(Str);

        Class clas=Student.class;
        System.out.println(clas.getSimpleName());
    }
}
