package com.springBootTest.service;

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
public class FunctionService {

    public String sayHello(String world){
        return "Hello "+world;
    }
}
