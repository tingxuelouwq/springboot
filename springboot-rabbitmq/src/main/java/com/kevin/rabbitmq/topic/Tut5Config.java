package com.kevin.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 类名: Tut5Config<br/>
 * 包名：com.kevin.rabbitmq.topic<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/19 15:56<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Profile({"tut5", "topics"})
@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("tut.topic");
    }

    @Profile("receiver")
    private static class ReceiverConfig {
        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1a(TopicExchange topic, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                    .to(topic)
                    .with("*.orange.*");
        }

        @Bean
        public Binding binding1b(TopicExchange topic, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                    .to(topic)
                    .with("*.*.rabbit");
        }

        @Bean
        public Binding binding2a(TopicExchange topic, Queue autoDeleteQueue2) {
            return BindingBuilder.bind(autoDeleteQueue2)
                    .to(topic)
                    .with("lazy.#");
        }

        @Bean
        public Tut5Receiver receiver() {
            return new Tut5Receiver();
        }
    }

    @Profile("sender")
    @Bean
    public Tut5Sender sender() {
        return new Tut5Sender();
    }
}
