package com.kevin.springboot.dao;

import com.kevin.springboot.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(username, user_pwd, email, mobile_no) values(#{username}, #{userPwd}, #{email}, #{mobileNo})")
    int insert(User user);

    @Delete("delete from user where id=#{id}")
    int delete(long id);

    @Update("update user set username=#{username}, user_pwd=#{userPwd}, email=#{email}, mobile_no=#{mobileNo}")
    int update(User user);

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "user_pwd", property = "userPwd", javaType = String.class),
            @Result(column = "email", property = "email", javaType = String.class),
            @Result(column = "mobile_no", property = "mobileNo", javaType = String.class)
    })
    User select(long id);

    @DeleteProvider(type = UserSqlBuilder.class, method = "deleteByIds")
    int deleteByIds(@Param("ids") String[] ids);

    class UserSqlBuilder {
        public String deleteByIds(@Param("ids") String[] ids) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from user where id in(");
            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    sql.append(ids[i]);
                } else {
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }

    @Select("select * from user where username=#{username} and user_pwd=#{userPwd}")
    @Results({
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "user_pwd", property = "userPwd", javaType = String.class),
            @Result(column = "email", property = "email", javaType = String.class),
            @Result(column = "mobile_no", property = "mobileNo", javaType = String.class)
    })
    User verify(@Param("username") String username, @Param("userPwd") String userPwd);

    @Select("select * from user")
    @Results({
            @Result(column = "username", property = "username", javaType = String.class),
            @Result(column = "user_pwd", property = "userPwd", javaType = String.class),
            @Result(column = "email", property = "email", javaType = String.class),
            @Result(column = "mobile_no", property = "mobileNo", javaType = String.class)
    })
    List<User> listAll();
}
