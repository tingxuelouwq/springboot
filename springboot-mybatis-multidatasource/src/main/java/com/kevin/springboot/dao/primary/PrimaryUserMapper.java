package com.kevin.springboot.dao.primary;

import com.kevin.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface PrimaryUserMapper {

    int insert(User user);

    int delete(long id);

    int update(User user);

    User select(long id);

    int deleteByIds(String[] ids);

    User verify(Map<String, String> params);

    List<User> listAll();
}
