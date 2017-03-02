package com.springBootBasic.myListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Title:
 * Description: 应用启动监听
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/2/28
 */
public class ApplicationListenerStartup implements ApplicationListener<ContextRefreshedEvent>{

    private Logger logger=Logger.getLogger(ApplicationListenerStartup.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        logger.info("项目的SwaggerUI的访问地址：http://localhost:9090/SpringBoot/swagger-ui.html");
    }
}
