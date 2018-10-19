package com.kevin.rabbitmq.rpc;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 类名: Tut6Client<br/>
 * 包名：com.kevin.rabbitmq.rpc<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 16:56<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Tut6Client {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange exchange;

    int start = 0;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        System.out.println(" [x] Requesting fib(" + start + ")");
        Integer response = (Integer) template.convertSendAndReceive
                (exchange.getName(), "rpc", start++);
        System.out.println(" [.] Got '" + response + "'");
    }
}
