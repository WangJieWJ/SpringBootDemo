package com.springbootbasic.test;

import java.util.Objects;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/6/2
 */
public class TestDemo3 {

    public static void main(String[] args) {
        Integer a=268;
        Integer b=268;
        System.out.println("【判等=：】"+(a==b));
        System.out.println("【判等equals：】"+(Objects.equals(a,b)));
        a=396;
        System.out.println("a:"+a+" b:"+b);
        String str="";
        switch (str){
            case "1":
                System.out.println("【print 15】");
                break;
            case "2323":
                System.out.println("【print 158】");
                break;
            default:
                System.out.println("default");
        }


    }
}
