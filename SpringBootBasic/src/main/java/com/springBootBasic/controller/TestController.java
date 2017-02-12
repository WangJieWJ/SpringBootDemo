package com.springBootBasic.controller;

import com.springBootBasic.config.RabbitMQConfig;
import com.springBootBasic.constants.RabbitMQConstant;
import com.springBootBasic.pojo.AuthorSettings;
import com.springBootBasic.pojo.Student;
import com.springBootBasic.rabbitmqMessage.RabbitMQ_Send;
import com.springBootBasic.redisCache.RedisUtil;
import com.springBootBasic.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * Title: 测试Controller
 * Description:
 *
 * @Api注解用来表述该服务的信息，如果不使用则显示类名称.
 * @ApiOperation注解用于表述接口信息
 * @ApiParam注解用于描述接口的参数 Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/9 0009.
 */
@Api(value = "测试Controller", description = "主要提供测试的Controller")
@RestController
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TestService testService;

    @Autowired
    private RabbitMQ_Send rabbitMQ_send;

    private Logger logger = Logger.getLogger(TestController.class);

    // 常规属性的配置
    @Value("${create.author}")
    private String author;

    @ApiOperation(value = "读取配置文件中的数据")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getStr() {
        return "Hello World " + author;
    }

    // 类型安全的配置
    @Autowired
    private AuthorSettings authorSettings;

    @ApiOperation(value = "读取配置文件中的数据，使用持久化对象")
    @RequestMapping(value = "/index1", method = RequestMethod.POST)
    public String getStr1() {
        return "使用类型安全的配置：author name is " + authorSettings.getName() + " and author age is " + authorSettings.getAge();
    }


    //规定请求的方式只能是POST请求
    //规定参数Username为必传参数(RequestParam)，id和age为可选
    @ApiOperation(value = "测试参数必传@RequestParam")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Username",value = "用户名",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "id",value = "用户ID",dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "age",value = "用户年龄",dataType = "Integer",paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam String Username, Long id, Integer age) {
        return Username + " POST方式登录成功！！！ id:" + id + " age" + age;
    }


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

    @ApiOperation(value = "使用RabbitMQ发送消息")
    @ApiImplicitParam(name = "msg",value = "消息内容",required = true,dataType = "String",paramType = "query")
    @RequestMapping(value = "/rabbitMQ",method = RequestMethod.POST)
    public void sendRabbitMQ(@RequestParam String msg){
        rabbitMQ_send.sendMessage(RabbitMQConfig.ROUTINGKEY1,msg,RabbitMQConstant.APP2, RabbitMQConstant.APP3);
    }
}
