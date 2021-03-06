package com.springbootbasic.test;

import java.util.Map;

/**
 * Title:
 * Description: 测试值传递 与 引用传递 问题
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/17
 */
public class TestDemo1 {

    /**
     * main方法
     * @param args 参数.
     */
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

        int[] a1=new int[]{1,2,3,4,5,6};
        int[] a2=new int[]{};
        a2=a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i]=a2[i]+1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }

        byte a= 121;

    }

    /**
     * 按值传递
     * 在Java里面只有基本类型和按照下面这种定义方式的String是按值传递，其它的都是按引用传递。
     * 就是直接使用双引号定义字符串方式：String str = “Java私塾”;
     * @param str cansh.
     */
    private static void test1(String str) {
        str = str + " World";
        System.out.println(str);
    }

    /**
     * 按址传递
     * @param map canshu.
     */
    private static void test2(Map map) {
        map.put("Hello", "World");
    }
}
