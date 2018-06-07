package com.space.rabbitmq.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者2
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
//@Component
public class SecondConsumer {

    /*@RabbitListener(queues = {"first-queue","second-queue"})
    public void handleMessage(Message message) throws Exception {
        // 处理消息
        System.out.println("SecondConsumer {} handleMessage :"+message);
    }*/
}
