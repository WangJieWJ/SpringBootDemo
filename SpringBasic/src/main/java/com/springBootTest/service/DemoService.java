package com.springBootTest.service;

import org.springframework.stereotype.Service;

/**
 * Title: 测试组合注解
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
@Service
public class DemoService {

    public void outPutResult(){
        System.out.println("从组合注解配置照样获得的bean");
    }
}
