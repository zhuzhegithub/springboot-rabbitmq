package com.space.rabbitmq.customer.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuzhe
 * @date 2018/5/25 13:56
 * @email 1529949535@qq.com
 */
@Configuration
public class RabbitListenerConf {

    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 具体处理
        System.out.println("RabbitListenerConf {} handleMessage :"+message);
    }
}
