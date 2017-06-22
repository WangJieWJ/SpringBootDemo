package com.springbootbasic.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Title:
 * Description:  添加静态资源的访问路径
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/13 0013
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
