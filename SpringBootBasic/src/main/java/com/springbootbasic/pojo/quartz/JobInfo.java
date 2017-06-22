package com.springbootbasic.pojo.quartz;

import java.io.Serializable;

/**
 * Title:
 * Description: Job(定时任务)的实体类
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/1
 */
public class JobInfo implements Serializable{
    private int id;                 //定时任务ID
    private String name;            //定时任务的简介
    private String appName;         //应用名称
    private String triggerCron;     //时间的表达式
    private String triggerName;     //目标类的引用
    private String crTime;          //创建时间
    private String crUser;          //创建时间
    private String status;          //状态，1表示启用，2表示删除

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTriggerCron() {
        return triggerCron;
    }

    public void setTriggerCron(String triggerCron) {
        this.triggerCron = triggerCron;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getCrTime() {
        return crTime;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime;
    }

    public String getCrUser() {
        return crUser;
    }

    public void setCrUser(String crUser) {
        this.crUser = crUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appName='" + appName + '\'' +
                ", triggerCron='" + triggerCron + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", crTime=" + crTime +
                ", crUser='" + crUser + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
