package com.springBootBasic.quartJob;

import com.springBootBasic.quartJob.base.MyQuartJob;
import org.apache.log4j.Logger;
import org.quartz.*;

import java.util.Map;

/**
 * Title:
 * Description: 计划任务
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/12 0012
 */
public class TestJob implements MyQuartJob {

    private Logger logger=Logger.getLogger(TestJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        //定时任务的下次执行时间
//        jobExecutionContext.getNextFireTime();

        //可以通过此方法获取定时任务初始化时候，设定的一些参数。
        JobDataMap data=jobExecutionContext.getJobDetail().getJobDataMap();
        Map<String,Object> map= (Map<String, Object>) data.get(MyQuartJob.QUARTJOB);

        logger.info("我是1分钟一次的定时任务：Hello World Java 执行表达式:"+map.get(MyQuartJob.TRIGGERCRON)+"  下一次执行时间："+jobExecutionContext.getNextFireTime());
    }
}
