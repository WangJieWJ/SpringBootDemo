package com.springBootTest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Title: 计划任务配置类，定时任务
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
@Configuration
@ComponentScan("com.springBootTest")
@EnableScheduling
public class TaskSchedulerConfig {
}
