package com.kevin.springboot.controller;

import com.kevin.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/users")
    public ModelAndView listUsers() {
        List<User> users = new ArrayList<User>(){
            {
                add(new User("kevin", 25));
                add(new User("tom", 25));
                add(new User("marry", 25));
                add(new User("george", 25));
                add(new User("john", 25));
                add(new User("bob", 25));
                add(new User("mike", 25));
                add(new User("linda", 25));
            }
        };

        ModelAndView modelAndView = new ModelAndView("/users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
