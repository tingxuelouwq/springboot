package com.kevin.rabbitmq.routing;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 类名: Tut4Sender<br/>
 * 包名：com.kevin.rabbitmq.routing<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 15:25<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Tut4Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    private int index;

    private int count;

    private final String[] keys = {"orange", "black", "green"};

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (++this.index == 3) {
            this.index = 0;
        }

        String key = keys[this.index];
        builder.append(key).append(' ');
        builder.append(Integer.toString(++this.count));
        String message = builder.toString();
        template.convertAndSend(direct.getName(), key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
