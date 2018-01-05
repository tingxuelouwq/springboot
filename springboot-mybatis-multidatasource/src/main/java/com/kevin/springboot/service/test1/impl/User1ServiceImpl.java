package com.kevin.springboot.service.test1.impl;

import com.kevin.springboot.dao.test1.User1Mapper;
import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.test1.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class User1ServiceImpl implements User1Service {

    @Autowired
    private User1Mapper user1Mapper;

    @Override
    public int insert(User user) {
        return user1Mapper.insert(user);
    }

    @Override
    public int delete(long id) {
        return user1Mapper.delete(id);
    }

    @Override
    public int update(User user) {
        return user1Mapper.update(user);
    }

    @Override
    public User select(int id) {
        return user1Mapper.select(id);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return user1Mapper.deleteByIds(ids);
    }

    @Override
    public User verify(Map<String, String> params) {
        return user1Mapper.verify(params);
    }

    @Override
    public List<User> listAll() {
        return user1Mapper.listAll();
    }
}
