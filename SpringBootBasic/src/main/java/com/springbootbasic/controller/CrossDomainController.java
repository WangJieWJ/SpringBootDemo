package com.springbootbasic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Title:.
 * Description: 测试 AJAX 跨域请求问题
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/13。
 */
@Api(value = "测试Controller", description = "主要提供测试的Controller")
@RestController
public class CrossDomainController {

    /**
     * .
     */
    Logger logger = Logger.getLogger(CrossDomainController.class);

    /**
     * 使用 Test2.html 页面来测试
     *
     * @return
     */
    @ApiOperation(value = "根据访问的域名打印Cookie值")
    @RequestMapping(value = "/getCookie", method = RequestMethod.POST)
    public String getCookie() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //是否是身份
//        response.setHeader("Access-Control-Allow-Credentials","true");
        //允许所有调用调用的域名  来调用
//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));

        System.out.println("ContextPath:" + request.getContextPath());
        System.out.println("RequestURL:" + request.getRequestURL().toString());
        System.out.println("ContentType:" + request.getContentType());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String item = enumeration.nextElement();
            System.out.println(item + ":" + request.getHeader(item));
        }
        System.out.println();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            System.out.println("输出Cookie中的所有值");
            for (Cookie cookie : cookies) {
                System.out.println("Key:" + cookie.getName() + " Value:" + cookie.getValue());
            }
        } else {
            System.out.println("没有Cookie值");
        }
        return "Hello World ";
    }
}
