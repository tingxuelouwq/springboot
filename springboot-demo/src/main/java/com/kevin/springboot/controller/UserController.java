package com.kevin.springboot.controller;

import com.kevin.springboot.domain.AnotherUser;
import com.kevin.springboot.domain.TestUser;
import com.kevin.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: UserController
 * @package: com.kevin.springboot.controller
 * @author: kevin[wangqi2017@xinhua.org]
 * @date: 2017/12/21 18:19
 * @version: 1.0
 * @desc:
 */
@RestController
public class UserController {

    @Value("${com.kevin.env}")
    private String env;

    @Autowired
    private User user;

    @Autowired
    private AnotherUser anotherUser;

    @Autowired
    private TestUser testUser;

    @RequestMapping("/user")
    public String userInfo() {
        return (user.getName() + " " + user.getAge() + " " + user.getDesc());
    }

    @RequestMapping("/another-user")
    public String anotherUserInfo() {
        return (anotherUser.getName() + " " + anotherUser.getAge() + " " + anotherUser.getDesc());
    }

    @RequestMapping("/env")
    public String envInfo() {
        return env;
    }

    @RequestMapping("/test-user")
    public String testUserInfo() {
        return (testUser.getDesc() + " " + testUser.getFramework());
    }
}
