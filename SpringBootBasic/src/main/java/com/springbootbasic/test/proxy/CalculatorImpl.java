package com.springbootbasic.test.proxy;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/23
 */
public class CalculatorImpl implements Calculator{

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
