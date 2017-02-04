package com.springBootTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title: 依赖注入测试
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
@Service
public class UseFunctionService {

    @Autowired
    public FunctionService functionService;

    public String sayHelloWorld(String World){
        return functionService.sayHello(World);
    }
}
