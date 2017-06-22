package com.springbootbasic.controller;

import com.springbootbasic.pojo.Student;
import com.springbootbasic.rediscache.RedisUtil;
import com.springbootbasic.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/9
 */
@Api(value = "Redis",description = "Redis的测试")
@RestController
public class RedisController {

    private static final Logger logger=Logger.getLogger(RedisController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TestService testService;


    /**
     * 测试Redis缓存
     *
     * @return
     */
    @ApiOperation(value = "测试Redis服务器的缓存")
    @RequestMapping(value = "/redis", method = RequestMethod.POST)
    public String getSessionId() {
        System.out.println(redisUtil.exists("HelloWorld2017"));
        redisUtil.set_Str("HelloWorld2017", "Java");
        System.out.println(redisUtil.get_Str("HelloWorld2017"));
        return "SUCCESS";
    }

    /**
     * 测试MySQL数据库连接
     * <p>
     * 并使用redis缓存。
     */
    @ApiOperation(value = "一个简易的数据缓存系统")
    @ApiImplicitParam(name = "xh", value = "学生学号", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/mysql", method = RequestMethod.POST)
    public String getSQLData(@RequestParam String xh) {
        //获取当前时间
        long stratTime = System.currentTimeMillis();
        Student student = testService.getStudentByXH(xh);
        long endTime = System.currentTimeMillis();
        logger.info("程序的运行时间：" + (endTime - stratTime) + "ms");
        return student == null ? "查询的数据为空" : student.toString();
    }
}
