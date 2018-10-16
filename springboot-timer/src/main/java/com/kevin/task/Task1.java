package com.kevin.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @类名: Task1
 * @包名：com.kevin.task
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/5/3 16:45
 * @版本：1.0
 * @描述：
 */
@Component
public class Task1 {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "this is scheduler task runing  " + (count++));
    }
}
