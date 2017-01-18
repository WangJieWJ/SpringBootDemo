package com.springBootBasic.controller;

import com.springBootBasic.pojo.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: 测试Controller
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/9 0009.
 */
@RestController
public class TestController {

    // 常规属性的配置
    @Value("${create.author}")
    private String author;

    @RequestMapping("/index")
    public String getStr(){
        return "Hello World "+author;
    }

    // 类型安全的配置
    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/index1")
    public String getStr1(){
        return "使用类型安全的配置：author name is "+authorSettings.getName()+" and author age is "+authorSettings.getAge();
    }
}
