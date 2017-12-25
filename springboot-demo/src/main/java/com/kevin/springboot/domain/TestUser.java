package com.kevin.springboot.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @class: TestUser
 * @package: com.kevin.springboot.domain
 * @author: kevin[wangqi2017@xinhua.org]
 * @date: 2017/12/22 14:55
 * @version: 1.0
 * @desc:
 */
@Configuration
@ConfigurationProperties(prefix = "com.test")
@PropertySource("classpath:test.properties")
public class TestUser {

    private String desc;
    private String framework;

    // getter and setter
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
}
