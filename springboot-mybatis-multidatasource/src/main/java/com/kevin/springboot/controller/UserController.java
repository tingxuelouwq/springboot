package com.kevin.springboot.controller;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.test1.User1Service;
import com.kevin.springboot.service.test2.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private User1Service user1Service;

    @Autowired
    private User2Service user2Service;

    @RequestMapping("/test1/users")
    public ModelAndView listTest1Users() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = user1Service.listAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping("/test2/users")
    public ModelAndView listTest2Users() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = user2Service.listAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
