package com.springbootbasic.controller;

import com.springbootbasic.config.RabbitMQConfig;
import com.springbootbasic.constants.RabbitMQConstant;
import com.springbootbasic.rabbitmqmessage.RabbitMQ_Send;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "RabbitMQ", description = "测试RabbitMQ来发送/接收消息")
@RestController
public class RabbitMQController {


    @Autowired
    private RabbitMQ_Send rabbitMQ_send;

    @ApiOperation(value = "使用RabbitMQ发送消息")
    @ApiImplicitParam(name = "msg", value = "消息内容", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/rabbitMQ", method = RequestMethod.POST)
    public void sendRabbitMQ(@RequestParam String msg) {
        rabbitMQ_send.sendMessage(RabbitMQConfig.ROUTINGKEY1, msg, RabbitMQConstant.APP2, RabbitMQConstant.APP3);
    }
}
