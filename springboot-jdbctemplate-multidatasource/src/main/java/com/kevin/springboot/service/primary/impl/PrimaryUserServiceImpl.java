package com.kevin.springboot.service.primary.impl;

import com.kevin.springboot.dao.primary.PrimaryUserDao;
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
    private PrimaryUserDao primaryUserDao;

    @Override
    public int insert(User user) {
        return primaryUserDao.insert(user);
    }

    @Override
    public int delete(long id) {
        return primaryUserDao.delete(id);
    }

    @Override
    public int update(User user) {
        return primaryUserDao.update(user);
    }

    @Override
    public User select(int id) {
        return primaryUserDao.select(id);
    }

    @Override
    public int deleteByIds(List<Long> ids) {
        return primaryUserDao.deleteByIds(ids);
    }

    @Override
    public User verify(Map<String, String> params) {
        return primaryUserDao.verify(params);
    }

    @Override
    public List<User> listAll() {
        return primaryUserDao.listAll();
    }
}
