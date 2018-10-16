package com.kevin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootMybatisMultidatasourceApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringbootMybatisMultidatasourceApplication.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
