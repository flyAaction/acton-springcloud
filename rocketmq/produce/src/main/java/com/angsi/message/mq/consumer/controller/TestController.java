package com.angsi.message.mq.consumer.controller;


import com.angsi.message.mq.consumer.provider.consumer.RocketMQConsumer;
import com.angsi.message.mq.consumer.provider.produce.RocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private RocketMqProducer rocketMQProvider;

    @Autowired
    private RocketMQConsumer consumer;

    @RequestMapping("/produceMq")
    public String testMq() {
        rocketMQProvider.defaultMQProducer();
        return "success";
    }

    @RequestMapping("/consumerMq")
    public String consumerMq() {
        consumer.defaultMQPushConsumer();
        return "success";
    }


}
