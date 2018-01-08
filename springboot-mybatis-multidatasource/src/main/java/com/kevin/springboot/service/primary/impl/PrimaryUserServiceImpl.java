package com.kevin.springboot.service.primary.impl;

import com.kevin.springboot.dao.primary.PrimaryUserMapper;
import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.primary.PrimaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional("primaryTransactionManager")
public class PrimaryUserServiceImpl implements PrimaryUserService {

    @Autowired
    private PrimaryUserMapper primaryUserMapper;

    @Override
    public int insert(User user) {
        return primaryUserMapper.insert(user);
    }

    @Override
    public int delete(long id) {
        return primaryUserMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return primaryUserMapper.update(user);
    }

    @Override
    public User select(int id) {
        return primaryUserMapper.select(id);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return primaryUserMapper.deleteByIds(ids);
    }

    @Override
    public User verify(Map<String, String> params) {
        return primaryUserMapper.verify(params);
    }

    @Override
    public List<User> listAll() {
        return primaryUserMapper.listAll();
    }
}
