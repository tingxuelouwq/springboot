package com.kevin.rabbitmq.pubsub;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 类名: Tut3Sender<br/>
 * 包名：com.kevin.rabbitmq.pubsub<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 14:34<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Tut3Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    int dots = 0;

    int count = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots++ == 3) {
            dots = 1;
        }
        for (int i = 0; i < dots; i++) {
            builder.append('.');
        }
        builder.append(Integer.toString(++count));
        String message = builder.toString();
        template.convertAndSend(fanout.getName(), "", message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
