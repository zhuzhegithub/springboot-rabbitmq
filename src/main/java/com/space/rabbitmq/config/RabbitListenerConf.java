package com.space.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhuzhe
 * @date 2018/5/25 13:56
 * @email 1529949535@qq.com
 */
@Component
public class RabbitListenerConf {

    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 具体处理
        System.out.println("RabbitListenerConf {} handleMessage :"+message);
    }
}
