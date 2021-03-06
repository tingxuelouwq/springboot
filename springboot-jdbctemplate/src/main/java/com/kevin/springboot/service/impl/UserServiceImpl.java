package com.kevin.springboot.service.impl;

import com.kevin.springboot.dao.UserDao;
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
    private UserDao userDao;

    @Override
    public User verify(String username, String userPwd) {
        return userDao.verify(username, userPwd);
    }

    @Override
    public List<User> listAll() {
        return userDao.listAll();
    }
}
