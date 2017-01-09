package com.springBootTest.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title: 计划(定时任务)测试
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次 "+format.format(new Date()));
    }

    @Scheduled(cron = "0 0/2 * * * ?")
    public void fixTimeExecution(){
        System.out.println("在指定的时间 "+format.format(new Date()) +"执行");
    }
}
