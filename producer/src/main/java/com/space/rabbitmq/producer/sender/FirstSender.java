package com.space.rabbitmq.producer.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhuzhe
 * @date 2018/5/25 14:28
 * @email 1529949535@qq.com
 */
@Slf4j
@Component
public class FirstSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param msg 消息内容
     * @param routingKey 路由关键字
     */
    public void setMessage(String msg, String routingKey) {
        rabbitTemplate.convertAndSend(routingKey, msg);
        log.info("rabbitmq--发送消息完成: routingKey[{}]-msg[{}]", routingKey, msg);
    }
}
