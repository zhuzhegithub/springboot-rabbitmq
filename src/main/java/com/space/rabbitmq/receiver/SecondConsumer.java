package com.space.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者2
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
@Component
public class SecondConsumer {

    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(Object message) throws Exception {
        // 处理消息
        System.out.println("SecondConsumer {} handleMessage :"+message);
    }
}
