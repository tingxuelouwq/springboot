package com.kevin.springboot.service;

import com.kevin.springboot.domain.User;

import java.util.List;

public interface UserService {

    int insert(User user);

    int delete(long id);

    int update(User user);

    User select(int id);

    int deleteByIds(String[] ids);

    User verify(String username, String userPwd);

    List<User> listAll();
}
