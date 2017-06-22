package com.springbootbasic.quartjob.base;

import org.quartz.Job;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/2
 */
public interface MyQuartJob extends Job{

    public static String QUARTJOB="Quart_Job";
    public static String TRIGGERCRON="Trigger_Cron";
    public static String TRIGGERNAME="Trigger_Name";

}
