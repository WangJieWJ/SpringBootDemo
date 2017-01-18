package com.springBootBasic;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: SpringBoot启动类
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/9 0009.
 */
@SpringBootApplication
public class SpringBootApp {

    public static void main(String[] args){
//        SpringApplication.run(SpringBootApp.class,args);
        SpringApplication app=new SpringApplication(SpringBootApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
