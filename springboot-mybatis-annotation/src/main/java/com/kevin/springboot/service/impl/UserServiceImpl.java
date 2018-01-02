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
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(long id) {
        return userMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User select(int id) {
        return userMapper.select(id);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return userMapper.deleteByIds(ids);
    }

    @Override
    public User verify(String username, String userPwd) {
        return userMapper.verify(username, userPwd);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }
}
