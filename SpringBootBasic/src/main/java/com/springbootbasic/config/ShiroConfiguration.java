//package com.springBootBasic.config;
//
//import org.apache.log4j.Logger;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Title:
// * Description:  Shifo配置
// * Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。
// * 既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，
// * 所以我们需要定义一系列关于URL的规则和访问权限。
// * Project: SpringBoot
// * Create User: wangjie
// * Create Time: 2017/2/14 0014
// */
//@Configuration
//public class ShiroConfiguration {
//
//    private Logger logger=Logger.getLogger(ShiroConfiguration.class);
//
//    /**
//     * ShiroFilterFactoryBean 处理拦截资源文件问题
//     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
//     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
//     *
//     *  Filter Chain定义说明
//     *  1、一个URL可以配置多个Filter，使用逗号分隔
//     *  2、当设置多个过滤器时，全部验证通过，才视为通过
//     *  3、部分过滤器可指定参数，如perms，roles
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
//        logger.info("ShiroConfiguration.shirFilter()");
//        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
//
//        //必须设置SecurityManager
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        //拦截器
//        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<String,String>();
//
//        //配置退出过滤器，其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/logout","logout");
//
//        //过滤链定义，从上向下顺序执行，一般将/**放在最
//        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-
//        filterChainDefinitionMap.put("/**","authc");
//
//        //如果不设置默认会自动寻找Web工程根目录下的
//        shiroFilterFactoryBean.setLoginUrl("/static/html/login.html");
//        //登陆成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/static/html/index.html");
//        //未授权界面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    public SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
//        return securityManager;
//    }
//}
