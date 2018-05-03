package com.kevin.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @类名: Task2
 * @包名：com.kevin.task
 * @作者：kevin[wangqi2017@xinhua.org]
 * @时间：2018/5/3 16:47
 * @版本：1.0
 * @描述：
 */
@Component
public class Task2 {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("[" + Thread.currentThread().getName() + "]" + "现在时间：" + dateFormat.format(new Date()));
    }
}
