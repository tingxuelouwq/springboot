package com.kevin.springboot.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @class: User
 * @package: com.kevin.springboot.domain
 * @author: kevin[wangqi2017@xinhua.org]
 * @date: 2017/12/21 18:32
 * @version: 1.0
 * @desc:
 */
@Configuration
public class User {

    // 获取application.properties中的属性
    @Value("${com.kevin.name}")
    private String name;

    @Value("${com.kevin.age}")
    private int age;

    @Value("${com.kevin.desc}")
    private String desc;

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
