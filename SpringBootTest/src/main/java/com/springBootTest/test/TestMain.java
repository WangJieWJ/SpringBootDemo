package com.springBootTest.test;

import com.springBootTest.config.AnnotationConfig;
import com.springBootTest.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
public class TestMain {

    public static void main(String[] args){
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DiConfig.class);
//
//        UseFunctionService functionService=context.getBean(UseFunctionService.class);
//        System.out.println(functionService.sayHelloWorld("Java"));
//
//        context.close();


//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
//
//        AsyncTaskService asyncTaskService=context.getBean(AsyncTaskService.class);
//        for(int i=0;i<10;i++){
//            asyncTaskService.executeAsyncTask(i);
//            asyncTaskService.executeAsyncTaskPlus(i);
//        }
//
//        context.close();


//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
//
////      定时任务只需要配置好，并初始化Spring容器即可
////        context.close();l


        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AnnotationConfig.class);

        DemoService demoService=context.getBean(DemoService.class);
        demoService.outPutResult();

        context.close();

    }
}
