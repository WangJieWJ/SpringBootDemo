package com.springBootTest.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * Title: 组合注解
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration   //组合@Configuration元注解
@ComponentScan   //组合@ComponentScan元注解
public @interface AnnotationDemo {

    String[] value() default {};
}
