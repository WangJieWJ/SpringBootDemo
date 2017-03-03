package com.springBootBasic.quartJob;

import com.springBootBasic.quartJob.base.MyQuartJob;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Map;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/2
 */
public class TestJob2 implements MyQuartJob{

    private Logger logger=Logger.getLogger(TestJob2.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap data=jobExecutionContext.getJobDetail().getJobDataMap();
        Map<String,Object> map= (Map<String, Object>) data.get(MyQuartJob.QUARTJOB);

        logger.info("TestJob2：这是两分钟一次的定时任务 ,triggerCron: "+map.get(MyQuartJob.TRIGGERCRON)+"  定时任务下一次执行的时间："+jobExecutionContext.getNextFireTime());
    }
}
