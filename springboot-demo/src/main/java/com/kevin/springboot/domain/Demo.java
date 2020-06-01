package com.kevin.springboot.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @类名: Demo<br />
 * @包名：com.kevin.springboot.domain<br/>
 * @作者：kevin<br/>
 * @时间：2020/6/1 16:25<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class Demo implements Serializable {

    @NotNull
    private String name;

    @NotNull
    private String password;

    private String special;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }
}
