package com.springbootbasic;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Title: SpringBoot启动类
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/9 0009.
 */
@EnableAspectJAutoProxy        //开启AOP
@EnableTransactionManagement   //开启事务管理
@SpringBootApplication
public class SpringBootApp {


    public static void main(String[] args) {
//        SpringApplication.run(SpringBootApp.class,args);
        SpringApplication app = new SpringApplication(SpringBootApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
