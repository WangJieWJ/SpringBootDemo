package com.springBootBasic.myRunner;

import com.springBootBasic.pojo.quartz.JobInfo;
import com.springBootBasic.quartJob.base.MyQuartJob;
import com.springBootBasic.service.QuartJobService;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:  项目启动的时候加载所有的定时任务
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/2/28
 */
@Component
@Order(value = 1)
public class MyStartupRunner1 implements CommandLineRunner {

    private Logger logger = Logger.getLogger(MyStartupRunner1.class);

    @Autowired
    private QuartJobService quartJobService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        logger.info("开始加载现有的所有定时任务");

        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        int count=0;
        List<JobInfo> quartJobList = quartJobService.getAllQuartJob();
        if (quartJobList != null && quartJobList.size() > 0) {
            for (JobInfo jobInfo : quartJobList) {
                try {
                    Class clazz = Class.forName(jobInfo.getTriggerName());

                    JobDetail job = JobBuilder.newJob(clazz).withIdentity("job_"+count,scheduler.getSchedulerInstanceId()).build();

                    Map<String,Object> map=new HashMap<String,Object>();
                    map.put(MyQuartJob.TRIGGERCRON,jobInfo.getTriggerCron());
                    map.put(MyQuartJob.TRIGGERNAME,jobInfo.getTriggerName());
                    job.getJobDataMap().put(MyQuartJob.QUARTJOB,map);

                    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("job_"+count,scheduler.getSchedulerInstanceId()).withSchedule(CronScheduleBuilder.cronSchedule(jobInfo.getTriggerCron())).build();  //省略  .withIdentity("trigger1", "grou")
                    scheduler.scheduleJob(job, trigger);
                    System.out.println("定时任务加载成功："+jobInfo.toString());
                    count++;
                } catch (Exception e) {
                    logger.error("定时任务加载失败，目标类为：" + jobInfo.getTriggerName() + ",执行时间为：" + jobInfo.getTriggerCron());
                }
            }
        }
        scheduler.start();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
