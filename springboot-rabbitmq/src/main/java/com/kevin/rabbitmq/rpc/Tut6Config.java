package com.kevin.rabbitmq.rpc;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 类名: Tut6Config<br/>
 * 包名：com.kevin.rabbitmq.rpc<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 16:51<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Profile({"tut6", "rpc"})
@Configuration
public class Tut6Config {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tut.rpc");
    }

    @Profile("client")
    private static class ClientConfig {
        @Bean
        public Tut6Client client() {
            return new Tut6Client();
        }
    }

    @Profile("server")
    private static class ServerConfig {
        @Bean
        public Queue queue() {
            return new Queue("tut.rpc.requests");
        }

        @Bean
        public Binding binding(DirectExchange exchange, Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with("rpc");
        }

        @Bean
        public Tut6Server server() {
            return new Tut6Server();
        }
    }
}
