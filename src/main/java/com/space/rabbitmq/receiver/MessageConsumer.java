package com.space.rabbitmq.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * 消费端
 * @author zhuzhe
 * @date 2018/5/25 15:57
 * @email 1529949535@qq.com
 */
public class MessageConsumer implements ChannelAwareMessageListener{

    @Override
    public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
        byte[] body = message.getBody();
        System.out.println("收到消息1 : " + new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
    }
}
