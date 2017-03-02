package com.springBootBasic.quartJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Title:
 * Description: 计划任务
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/12 0012
 */
public class TestJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("我是1分钟一次的定时任务：Hello World Java ");
    }
}
