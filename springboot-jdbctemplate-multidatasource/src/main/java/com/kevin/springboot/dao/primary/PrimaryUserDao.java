package com.kevin.springboot.dao.primary;

import com.kevin.springboot.domain.User;

import java.util.List;
import java.util.Map;

public interface PrimaryUserDao {

    int insert(User user);

    int delete(long id);

    int update(User user);

    User select(long id);

    int deleteByIds(List<Long> ids);

    User verify(Map<String, String> params);

    List<User> listAll();
}
