package com.springbootbasic.test.proxy;


import java.lang.reflect.Proxy;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/23
 */
public class testDynamicProxy {

    public static void main(String[] args) {

        Calculator calculator=new CalculatorImpl();
        LogHandler logHandler=new LogHandler(calculator);
        calculator= (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),calculator.getClass().getInterfaces(),logHandler);
        System.out.println(calculator.add(1,2));
    }
}
