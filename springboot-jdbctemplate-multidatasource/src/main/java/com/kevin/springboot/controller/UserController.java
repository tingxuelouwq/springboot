package com.kevin.springboot.controller;

import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.primary.PrimaryUserService;
import com.kevin.springboot.service.secondary.SecondaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PrimaryUserService primaryUserService;

    @Autowired
    private SecondaryUserService secondaryUserService;

    @RequestMapping("/primary/users")
    public ModelAndView listPrimaryUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = primaryUserService.listAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping("/secondary/users")
    public ModelAndView listSecondaryUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        List<User> users = secondaryUserService.listAll();
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
