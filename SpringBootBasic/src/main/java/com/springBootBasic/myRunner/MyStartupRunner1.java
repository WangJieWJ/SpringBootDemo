package com.springBootBasic.myRunner;

import com.springBootBasic.dao.TestDao;
import com.springBootBasic.pojo.base.JobInfo;
import com.springBootBasic.quartJob.TestJob;
import com.springBootBasic.service.QuartJobService;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/2/28
 */
@Component
@Order(value = 2)
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


        List<JobInfo> quartJobList = quartJobService.getAllQuartJob();
        if (quartJobList != null && quartJobList.size() > 0) {
            for (JobInfo jobInfo : quartJobList) {
                try {
                    Class clazz = Class.forName(jobInfo.getTriggerName());

                    JobDetail job = JobBuilder.newJob(clazz).build();
                    Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(jobInfo.getTriggerCron())).build();  //省略  .withIdentity("trigger1", "grou")
                    scheduler.scheduleJob(job, trigger);
                    System.out.println("定时任务加载成功："+jobInfo.toString());
                } catch (Exception e) {
                    logger.error("定时任务加载失败，目标类为：" + jobInfo.getTriggerName() + ",执行时间为：" + jobInfo.getTriggerCron());
                }
            }
        }
        scheduler.start();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
