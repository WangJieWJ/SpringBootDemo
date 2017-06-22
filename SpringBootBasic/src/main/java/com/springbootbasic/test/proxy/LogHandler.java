package com.springbootbasic.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Title:
 * Description: 动态代理
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/23
 */
public class LogHandler implements InvocationHandler{

    Object object;
    LogHandler(Object object){
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object returnObj=method.invoke(object,args);
        doAfter();
        return returnObj;
    }

    public void doBefore(){
        System.out.println("do this Before!!!!");
    }

    public void doAfter(){
        System.out.println("do this After!!!!!");
    }
}
