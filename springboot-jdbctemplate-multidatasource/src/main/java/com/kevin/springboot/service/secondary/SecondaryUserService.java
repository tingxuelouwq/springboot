package com.kevin.springboot.service.secondary;

import com.kevin.springboot.domain.User;

import java.util.List;
import java.util.Map;

public interface SecondaryUserService {

    int insert(User user);

    int delete(long id);

    int update(User user);

    User select(int id);

    int deleteByIds(List<Long> ids);

    User verify(Map<String, String> params);

    List<User> listAll();
}
