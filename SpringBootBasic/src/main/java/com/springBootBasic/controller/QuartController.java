package com.springBootBasic.controller;

import com.alibaba.fastjson.JSONObject;
import com.springBootBasic.pojo.base.JobInfo;
import com.springBootBasic.service.QuartJobService;
import com.springboot.common.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Title:
 * Description: 定时任务的配置
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/1
 */
@Api(value = "定时任务的配置", description = "定时任务Controller")
@RestController
public class QuartController {

    @Autowired
    private QuartJobService quartJobService;


    @ApiOperation(value = "获取所有的定时任务")
    @RequestMapping(value = "getAllQuartJob", method = RequestMethod.POST)
    public String getAllQuartJob() {
        List<JobInfo> quartJobList = quartJobService.getAllQuartJob();
        return quartJobList == null ? "并未添加定时任务" : quartJobList.size() == 0 ? "并未添加定时任务" : JSONObject.toJSONString(quartJobList);
    }


    @ApiOperation(value = "新增定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", required = true, value = "定时任务名称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "appName", required = true, value = "应用名称", dataType = "String", paramType = "query",defaultValue = "SpringBoot"),
            @ApiImplicitParam(name = "triggerCron", required = true, value = "定时任务的执行时间表达式", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "triggerName", required = true, value = "定时任务的目标类", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "crUser", required = true, value = "创建者", dataType = "String", paramType = "query",defaultValue = "WangJie"),
            @ApiImplicitParam(name = "status", required = true, value = "定时任务的状态", dataType = "String", paramType = "query",defaultValue = "1")
    })
    @RequestMapping(value = "addQuartJob", method = RequestMethod.POST)
    public String addQuartJob(@RequestParam String name, @RequestParam String appName, @RequestParam String triggerCron, @RequestParam String triggerName, @RequestParam String crUser, @RequestParam String status) {
        JobInfo quartJob = new JobInfo();
        quartJob.setName(name);
        quartJob.setAppName(appName);
        quartJob.setTriggerCron(triggerCron);
        quartJob.setTriggerName(triggerName);
        quartJob.setCrTime(DateUtil.getFormatDateStr("yyyy-MM-dd", new Date()));
        quartJob.setCrUser(crUser);
        quartJob.setStatus(status);
        return quartJobService.addQuartJob(quartJob) == 0 ? "定时任务添加失败" : "定时任务添加成功";
    }

    @ApiOperation(value = "删除定时任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "定时任务ID", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "delQuartJob",method = RequestMethod.POST)
    public String delQuartJob(@RequestParam Integer id){
        return quartJobService.delQuartJob(id)==0?"定时任务删除失败":"定时任务删除成功";
    }
}
