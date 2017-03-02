package com.springBootBasic.service;

import com.springBootBasic.dao.QuartJobDao;
import com.springBootBasic.pojo.base.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Description: 定时任务Service
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/1
 */
@Service
public class QuartJobService {

    @Autowired
    private QuartJobDao quartJobDao;

    /**
     * 获取所有的QuartJob
     * @return
     */
    public List<JobInfo> getAllQuartJob(){
        return quartJobDao.getAllQuartJob();
    }

    /**
     * 添加定时任务
     * @param jobInfo
     * @return
     */
    public int addQuartJob(JobInfo jobInfo){
        return quartJobDao.addQuartJob(jobInfo);
    }

    /**
     * 删除定时任务
     * @param id
     * @return
     */
    public int delQuartJob(int id){
        return quartJobDao.delQuartJob(id);
    }
}
