package com.kevin.rabbitmq.helloworld;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 类名: Tut1Receiver<br/>
 * 包名：com.kevin.rabbitmq.helloworld<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/16 15:39<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@RabbitListener(queues = "hello")
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
    }
}
