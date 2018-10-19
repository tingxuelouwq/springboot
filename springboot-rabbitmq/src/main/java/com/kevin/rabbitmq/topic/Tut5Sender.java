package com.kevin.rabbitmq.topic;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 类名: Tut5Sender<br/>
 * 包名：com.kevin.rabbitmq.topic<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 16:28<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Tut5Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange topic;

    private int index;

    private int count;

    private final String[] keys = {
            "quick.orange.rabbit",
            "lazy.orange.elephant",
            "quick.orange.fox",
            "lazy.brown.fox",
            "lazy.pink.rabbit",
            "quick.brown.fox"
    };

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++this.index == keys.length) {
            this.index = 0;
        }
        String key = keys[this.index];
        builder.append(key).append(' ');
        builder.append(Integer.toString(++this.count));
        String message = builder.toString();
        template.convertAndSend(topic.getName(), key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
