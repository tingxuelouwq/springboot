package com.kevin.springboot.service.impl;

import com.kevin.springboot.service.ProfileService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * 类名: DecProfileServiceImpl<br/>
 * 包名：com.kevin.springboot.service.impl<br/>
 * 作者：kevin[wangqi2017@xinhua.org]<br/>
 * 时间：2018/10/16 14:45<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Profile("dev")
@Service
public class DecProfileServiceImpl implements ProfileService {
    @Override
    public String getProfileDomain() {
        return "开发环境";
    }
}
