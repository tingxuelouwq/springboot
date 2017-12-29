package com.kevin.springboot.dao;

import com.kevin.springboot.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(username, user_pwd, email, mobile_no) values(#{username}, #{userPwd}, #{email}, #{mobileNo})")
    int add(User user);

    @Delete("delete from user where id=#{id}")
    int delete(int id);

    @Update("update user set username=#{username}, user_pwd=#{userPwd}, email=#{email}, mobile_no=#{mobileNo}")
    int update(User user);

    @Select("select * from user where id=#{id}")
    @Results()
    User select(int id);
}
