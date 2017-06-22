package com.springbootbasic.rabbitmqmessage;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description: RabbitMQ接收消息  消费者
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/10 0010
 */
@Component
public class RabbitMQ_Receive implements MessageListener{
    @Override
    public void onMessage(Message message) {
        System.out.println("Received DesignMessage [X] : "+message.toString()+" By MessageListener");
    }
}
