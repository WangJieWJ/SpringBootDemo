package com.springbootbasic.test;

import java.util.*;

/**
 * Title:
 * Description:
 * Copyright: 2017 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringBoot
 * Author: 王杰
 * Create Time:2017/11/29 15:08
 */
public class TestDemo4 {

    public static void main(String[] args) {


        Random random = new Random();
        List<Person> perList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Person per1 = new Person(UUID.randomUUID().toString(), random.nextInt(500));
            perList.add(per1);
        }
        int sum = 0;
        long time1 = System.currentTimeMillis();
        for (Person per : perList) {
            if (per.getAge() > 20) {
                sum += per.getAge();
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        long time3 = System.currentTimeMillis();
        perList.parallelStream().filter((p) -> p.getAge() > 20)
                .mapToInt((per) -> per.getAge())
                .sum();
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);

    }

    private static void deal(Map<String, Object> paramMap) {
        paramMap.put("test", "Hello World!");
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
