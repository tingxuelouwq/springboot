package com.kevin.springboot.controller;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.UserService;
import com.kevin.springboot.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping("/auth")
    public ModelAndView auth(@RequestParam(value = "username", required = false) String username,
                             @RequestParam(value = "userPwd", required = false) String userPwd,
                             HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(userPwd)) {
            modelAndView.addObject("errorMsg", "请输入用户名密码");
            return modelAndView;
        }

        User user = userService.getByUsername(username);
        if (user == null) {
            modelAndView.addObject("errorMsg", "用户名密码错误");
            return modelAndView;
        } else {
            session.setAttribute("user", user);
        }

        modelAndView.setViewName("forward:/users");
        return modelAndView;
    }
}
