package com.space.rabbitmq.producer.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMq配置
 * @author zhuzhe
 * @date 2018/5/25 13:37
 * @email 1529949535@qq.com
 */
@Configuration
public class RabbitMqConfig {

//    @Autowired
//    private ConnectionFactory connectionFactory;

    // 管理
    /*@Bean
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(connectionFactory);
    }*/

    /**
     * 配置监听连接
     * @param connectionFactory
     * @return
     */
    @Bean(name = "rabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory, RabbitProperties config) {
        RabbitProperties.Listener listenerConfig = config.getListener();
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        RabbitProperties.ContainerType type = listenerConfig.getType();
        if (RabbitProperties.ContainerType.SIMPLE.equals(type)) {
            RabbitProperties.SimpleContainer simple = listenerConfig.getSimple();
            factory.setAutoStartup(simple.isAutoStartup());
            if (simple.getAcknowledgeMode() != null) {
                factory.setAcknowledgeMode(simple.getAcknowledgeMode());
            }
            if (simple.getConcurrency() != null) {
                factory.setConcurrentConsumers(simple.getConcurrency());
            }
            if (simple.getMaxConcurrency() != null) {
                factory.setMaxConcurrentConsumers(simple.getMaxConcurrency());
            }
            if (simple.getPrefetch() != null) {
                factory.setPrefetchCount(simple.getPrefetch());
            }
            if (simple.getTransactionSize() != null) {
                factory.setTxSize(simple.getTransactionSize());
            }
        } else if(RabbitProperties.ContainerType.DIRECT.equals(type)){
            RabbitProperties.DirectContainer direct = listenerConfig.getDirect();
            factory.setAutoStartup(direct.isAutoStartup());
            if (direct.getAcknowledgeMode() != null) {
                factory.setAcknowledgeMode(direct.getAcknowledgeMode());
            }
            if (direct.getPrefetch() != null) {
                factory.setPrefetchCount(direct.getPrefetch());
            }
        }
        return factory;
    }

    /**
     * 具体监听队列及使用配置
     *
     * @param message
     * @throws Exception
     */
    /*@RabbitListener(queues = QUEUE_NAME, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 具体处理
    }*/

}
