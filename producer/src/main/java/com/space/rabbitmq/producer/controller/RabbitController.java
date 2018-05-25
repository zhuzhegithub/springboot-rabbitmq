package com.space.rabbitmq.producer.controller;

import com.space.rabbitmq.producer.config.RabbitListenerConf;
import com.space.rabbitmq.producer.receiver.FirstReceiver;
import com.space.rabbitmq.producer.sender.FirstSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuzhe
 * @date 2018/5/25 10:46
 * @email 1529949535@qq.com
 */
@Slf4j
@RestController
public class RabbitController {

    @Autowired
    private FirstSender firstSender;

    @Autowired
    private FirstReceiver firstReceiver;

    @Autowired
    private RabbitListenerConf rabbitListenerConf;

    @GetMapping(value = "/rabbit/setMessage")
    public String setMessage(String msg, String type) {
        log.info("rabbitmq--收到待发送消息: type[{}]-msg[{}]", type, msg);
        setMsg(msg, type);
        return "success";
    }

    @GetMapping(value = "/rabbit/receiveMessage")
    public String receiveMessage(String msg) {
        firstReceiver.onMessage(msg);
        try {
            rabbitListenerConf.handleMessage(msg);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "receiveMessage  success";
    }

    @Async
    public void setMsg(String msg, String type){
        firstSender.setMessage(msg, type);
    }
}
