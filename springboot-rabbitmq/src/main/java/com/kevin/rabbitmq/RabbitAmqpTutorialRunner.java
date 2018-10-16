package com.kevin.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 类名: RabbitAmqpTutorialRunner<br/>
 * 包名：com.kevin.rabbitmq<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/16 15:32<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class RabbitAmqpTutorialRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration: 0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ready ... running for " + duration + "ms");
        Thread.sleep(duration);
        ctx.close();
    }
}
