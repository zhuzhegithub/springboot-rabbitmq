package com.space.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者1
 * @author zhuzhe
 * @date 2018/5/25 17:32
 * @email 1529949535@qq.com
 */
@Component
public class FirstConsumer {

    /**
     * queues  指定从哪个队列（queue）订阅消息
     * @param message
     * @throws Exception
     */
    @RabbitListener(queues = {/*"first-queue",*/"second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(Object message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :"+message);
    }
}
