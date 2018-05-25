package com.space.rabbitmq.customer.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者2
 * @author zhuzhe
 * @date 2018/5/25 13:21
 * @email 1529949535@qq.com
 */
@Component
@RabbitListener(queues = "second-queue")
public class SecondReceiver {

    /**
     * 处理消息
     * @param message
     */
    @RabbitHandler
    public void onMessage(String message) {
        System.out.println("SecondReceiver onMessage  : " + message);
    }
}
