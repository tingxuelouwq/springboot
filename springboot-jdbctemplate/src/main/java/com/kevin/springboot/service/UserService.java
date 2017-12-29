package com.kevin.springboot.service;

import com.kevin.springboot.domain.User;

import java.util.List;

public interface UserService {

    User getByUsername(String username);

    List<User> listAll();
}
