package com.kevin.springboot.controller;

import com.kevin.springboot.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名: ProfileController<br/>
 * 包名：com.kevin.springboot.controller<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/16 14:45<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public String testProfile() {
        return profileService.getProfileDomain();
    }
}
