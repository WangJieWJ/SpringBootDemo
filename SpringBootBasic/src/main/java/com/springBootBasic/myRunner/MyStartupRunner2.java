package com.springBootBasic.myRunner;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/2/28
 */
@Component
@Order(value = 3)
public class MyStartupRunner2 implements CommandLineRunner{

    private Logger logger=Logger.getLogger(MyStartupRunner2.class);

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        logger.info("启动加载");
        logger.info("项目的SwaggerUI的访问地址：http://localhost:9090/SpringBoot/swagger-ui.html");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
