package com.kevin.springboot.service.primary;

import com.kevin.springboot.domain.User;

import java.util.List;
import java.util.Map;

public interface PrimaryUserService {

    int insert(User user);

    int delete(long id);

    int update(User user);

    User select(int id);

    int deleteByIds(String[] ids);

    User verify(Map<String, String> params);

    List<User> listAll();
}
