package com.kevin.springboot.service.secondary.impl;

import com.kevin.springboot.dao.secondary.SecondaryUserMapper;
import com.kevin.springboot.domain.User;
import com.kevin.springboot.service.secondary.SecondaryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional("secondaryTransactionManager")
public class SecondaryUserServiceImpl implements SecondaryUserService {

    @Autowired
    private SecondaryUserMapper secondaryUserMapper;

    @Override
    public int insert(User user) {
        return secondaryUserMapper.insert(user);
    }

    @Override
    public int delete(long id) {
        return secondaryUserMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return secondaryUserMapper.update(user);
    }

    @Override
    public User select(int id) {
        return secondaryUserMapper.select(id);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return secondaryUserMapper.deleteByIds(ids);
    }

    @Override
    public User verify(Map<String, String> params) {
        return secondaryUserMapper.verify(params);
    }

    @Override
    public List<User> listAll() {
        return secondaryUserMapper.listAll();
    }
}
