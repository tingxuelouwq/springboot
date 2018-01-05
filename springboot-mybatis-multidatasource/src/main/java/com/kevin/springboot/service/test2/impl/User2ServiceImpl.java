package com.kevin.springboot.service.test2.impl;

import com.kevin.springboot.dao.test2.User2Mapper;
import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.test2.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public int insert(User user) {
        return user2Mapper.insert(user);
    }

    @Override
    public int delete(long id) {
        return user2Mapper.delete(id);
    }

    @Override
    public int update(User user) {
        return user2Mapper.update(user);
    }

    @Override
    public User select(int id) {
        return user2Mapper.select(id);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return user2Mapper.deleteByIds(ids);
    }

    @Override
    public User verify(Map<String, String> params) {
        return user2Mapper.verify(params);
    }

    @Override
    public List<User> listAll() {
        return user2Mapper.listAll();
    }
}
