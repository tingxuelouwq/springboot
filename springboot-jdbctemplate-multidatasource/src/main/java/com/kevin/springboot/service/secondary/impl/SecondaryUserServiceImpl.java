package com.kevin.springboot.service.secondary.impl;

import com.kevin.springboot.dao.secondary.SecondaryUserDao;
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
    private SecondaryUserDao secondaryUserDao;

    @Override
    public int insert(User user) {
        return secondaryUserDao.insert(user);
    }

    @Override
    public int delete(long id) {
        return secondaryUserDao.delete(id);
    }

    @Override
    public int update(User user) {
        return secondaryUserDao.update(user);
    }

    @Override
    public User select(int id) {
        return secondaryUserDao.select(id);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return secondaryUserDao.deleteByIds(ids);
    }

    @Override
    public User verify(Map<String, String> params) {
        return secondaryUserDao.verify(params);
    }

    @Override
    public List<User> listAll() {
        return secondaryUserDao.listAll();
    }
}
