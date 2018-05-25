package com.space.rabbitmq.customer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列配置  可以配置多个队列
 * @author zhuzhe
 * @date 2018/5/25 13:25
 * @email 1529949535@qq.com
 */
@Configuration
public class QueueConfig {

    @Bean
    public Queue firstQueue() {
        return new Queue("first-queue");
    }

    @Bean
    public Queue secondQueue() {
        return new Queue("second-queue");
    }
}
