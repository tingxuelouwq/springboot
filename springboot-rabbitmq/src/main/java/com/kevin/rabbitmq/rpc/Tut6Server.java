package com.kevin.rabbitmq.rpc;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * 类名: Tut6Server<br/>
 * 包名：com.kevin.rabbitmq.rpc<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 16:54<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Tut6Server {

    @RabbitListener(queues = "tut.rpc.requests")
    public int fibonacci(int n) {
        System.out.println(" [x] Received request for " + n);
        int result = fib(n);
        System.out.println(" [.] Returned " + result);
        return result;
    }

    public int fib(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }
}
