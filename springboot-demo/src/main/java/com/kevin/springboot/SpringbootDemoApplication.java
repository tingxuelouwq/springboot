package com.kevin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringbootDemoApplication.class, args);
        SpringApplication application = new SpringApplication(SpringbootDemoApplication.class);
        // 禁止命令行设置启动参数
        application.setAddCommandLineProperties(false);
        application.run(args);
    }
}
