package com.kevin.timer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @类名: SchedulerConfig
 * @包名：com.kevin.timer
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/5/3 17:15
 * @版本：1.0
 * @描述：
 */
@Configuration
public class SchedulerConfig {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("spring-task-thread");
        return scheduler;
    }
}
