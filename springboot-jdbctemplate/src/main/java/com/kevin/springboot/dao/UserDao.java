package com.kevin.springboot.dao;

import com.kevin.springboot.domain.User;

import java.util.List;

public interface UserDao {

    User getByUsername(String username);

    List<User> listAll();
}
