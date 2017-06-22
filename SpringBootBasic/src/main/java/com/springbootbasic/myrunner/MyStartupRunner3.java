package com.springbootbasic.myrunner;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/11
 */
@Component
@Order(value = 3)
public class MyStartupRunner3 implements CommandLineRunner {

    private Logger logger = Logger.getLogger(MyStartupRunner3.class);

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        Resource resource = new ClassPathResource("shiro.ini");
        if (resource.exists()) {
            logger.info("开始加载shiro配置文件");

            //其实可以直接在此处配置MyRealm ，但此处选择从资源文件中读取配置
            //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
            Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

            //2、得到SecurityManager实例 并绑定给SecurityUtils
            SecurityManager securityManager = factory.getInstance();
            SecurityUtils.setSecurityManager(securityManager);

        } else {
            logger.info("shiro配置文件不存在");
        }


        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
