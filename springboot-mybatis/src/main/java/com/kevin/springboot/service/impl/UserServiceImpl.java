package com.kevin.springboot.service.impl;

import com.kevin.springboot.dao.UserMapper;
import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }
}
