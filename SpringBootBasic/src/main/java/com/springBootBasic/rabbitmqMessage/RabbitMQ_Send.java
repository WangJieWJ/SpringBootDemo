package com.springBootBasic.rabbitmqMessage;

import com.alibaba.fastjson.JSON;
import com.springBootBasic.config.RabbitMQConfig;
import com.springBootBasic.pojo.DesignMessage;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Title:
 * Description: RabbitMQ发送消息  生产者
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/10 0010
 */
@Component
public class RabbitMQ_Send implements RabbitTemplate.ConfirmCallback{

    private RabbitTemplate rabbitTemplate;

    private Logger logger=Logger.getLogger(RabbitMQ_Send.class);

    /**
     * 构造方法注入
     * @param rabbitTemplate
     */
    public RabbitMQ_Send(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
        //设置消费回调
        this.rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 发送消息的具体方法
     * @param routingkey
     * @param msg
     * @param toName
     * @return
     */
    public String sendMessage(String routingkey,String msg,String fromName,String toName){
        logger.info("开始发送消息msg:   "+msg);
        String uuid= UUID.randomUUID().toString();

        /**
         * 构造对象并序列化
         */
        Map<String,Object> data=new HashMap<String,Object>();
        data.put("data",msg);
        DesignMessage designMessage=new DesignMessage(uuid,fromName,toName,data);
        String sendMsg= JSON.toJSONString(designMessage);

        CorrelationData correlationData=new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE,routingkey,sendMsg,correlationData);
        return null;
    }

    /**
     * 消息的回调，主要实现RabbitTemplate.ConfirmCallback接口
     * 注意，消息回调只能代表成功消息发送到RabbitMQ服务器，不能代表消息被成功处理和接受
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.info(" 回调id:"+correlationData.getId());
        if(ack){
            logger.info("消息成功发送");
        }else{
            logger.info("消息发送失败："+cause);
        }
    }
}
