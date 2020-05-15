package com.angsi.message.mq.consumer.provider.produce;

import com.alibaba.fastjson.JSON;
import com.angsi.message.mq.consumer.domain.User;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 消息保存的载体:
 */
@Component
public class RocketMqProducer {

    /**
     * 生产者的组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    /**
     * 地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    public void defaultMQProducer() {
        //生产者的组名
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        //指定NameServer地址，多个地址以 ; 隔开
        producer.setNamesrvAddr(namesrvAddr);
        /**
         * Producer对象在使用之前必须要调用start初始化，初始化一次即可
         * 注意：切记不可以在每次发送消息时，都调用start方法
         */
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setName("abc" + i);
                user.setId(i);
                //创建一个消息实例，包含 topic、tag 和 消息体
                //如下：topic 为 "TopicTest"，tag 为 "push"
                Message message = new Message("topic-test", "push", JSON.toJSONString(user).getBytes());
                SendResult result = producer.send(message, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 1);
                System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
