package com.springBootTest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Title: 多线程测试
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer integer){
        System.out.println("执行异步任务："+integer);
    }

    @Async
    public void executeAsyncTaskPlus(Integer integer){
        System.out.println("执行异步任务+1："+(integer+1));
    }
}
