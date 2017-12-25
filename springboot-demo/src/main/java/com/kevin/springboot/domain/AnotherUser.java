package com.kevin.springboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @class: AnotherUser
 * @package: com.kevin.springboot.domain
 * @author: kevin[wangqi2017@xinhua.org]
 * @date: 2017/12/22 10:12
 * @version: 1.0
 * @desc:
 */
@Configuration
@ConfigurationProperties(prefix = "com.kevin")
public class AnotherUser {

    private String name;
    private int age;
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
