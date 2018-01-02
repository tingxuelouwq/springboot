package com.kevin.springboot.controller;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ModelAndView listUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = userService.listAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
