package com.springBootBasic.test;

import com.springBootBasic.pojo.Student;
import com.springBootBasic.quartJob.TestJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/9 0009
 */
public class TestDemo {

    public static void main(String[] args) throws SchedulerException {
//        String Str="http://www.haier.com.dadawdaddasdadhttphttp://www.haier.com";
//        Str=Str.replaceFirst("http://www.haier.com","http://image.haier.com");
//        System.out.println(Str);
//
//        Class clas=Student.class;
//        System.out.println(clas.getSimpleName());
//        SchedulerFactory factory = new StdSchedulerFactory();
//        // 从工厂里面拿到一个scheduler实例
//        Scheduler scheduler = factory.getScheduler();
//        // 计算任务的开始时间，DateBuilder.evenMinuteDate方法是取下一个整数分钟
//        Date runTime = DateBuilder.evenMinuteDate(new Date());
//        // 真正执行的任务并不是Job接口的实例，而是用反射的方式实例化的一个JobDetail实例
//        JobDetail job = JobBuilder.newJob(TestJob.class).withIdentity("job1", "group1").build();
//        // 定义一个触发器，startAt方法定义了任务应当开始的时间
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "grou").startNow().build();
//        // 将任务和Trigger放入scheduler
//        scheduler.scheduleJob(job, trigger);
//        scheduler.start();
//        try {
//            // 等待65秒，保证下一个整数分钟出现，这里注意，如果主线程停止，任务是不会执行的
//            Thread.sleep(65L * 1000L);
//        } catch (Exception e) {
//
//        }
//        // scheduler结束
//        scheduler.shutdown(true);

        test1();
//        String SQL="asdasd11";
//        System.out.println(SQL.substring(0,SQL.length()-1));

    }

    public static void test1(){
        String contentCp="275817,275407,275638,275637,276791,276791,276791,275407,275407,275407,275407,275407,275407";
        Set<String> set=new HashSet<String>();
        String []array=contentCp.split(",");
        int length=array.length;
        System.out.println(length);
        for(int i=0;i<length;i++){
            set.add(array[i]);
        }
        set.remove(275407+"");
        String SQL="";
        for(String s:set){
            SQL+=s+",";
        }
        System.out.println(SQL);
    }
}
