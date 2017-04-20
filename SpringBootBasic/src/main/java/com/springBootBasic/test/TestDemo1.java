package com.springBootBasic.test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Title:
 * Description: 测试值传递 与 引用传递 问题
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/17
 */
public class TestDemo1 {

    public static void main(String[] args) {

//        String str="123";
//        test1(str);
//        System.out.println(str);
//
//        Map<String,String> map=new HashMap<String,String>();
//        map.put("test","测试环境");
//        map.put("product","生产环境");
//        test2(map);
//        for (Map.Entry<String,String> string:map.entrySet()){
//            System.out.println(string.getValue());
//        }

    }

    /**
     * 按值传递
     * 在Java里面只有基本类型和按照下面这种定义方式的String是按值传递，其它的都是按引用传递。
     * 就是直接使用双引号定义字符串方式：String str = “Java私塾”;
     */
    private static void test1(String str) {
        str = str + " World";
        System.out.println(str);
    }

    /**
     * 按址传递
     */
    private static void test2(Map map) {
        map.put("Hello", "World");
    }
}
