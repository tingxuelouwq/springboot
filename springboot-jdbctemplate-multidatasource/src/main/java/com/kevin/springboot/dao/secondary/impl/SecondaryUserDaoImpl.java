package com.kevin.springboot.dao.secondary.impl;

import com.kevin.springboot.dao.secondary.SecondaryUserDao;
import com.kevin.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SecondaryUserDaoImpl implements SecondaryUserDao {

    @Autowired
    @Qualifier("secondaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int insert(User user) {
        String sql = "insert into user(username, user_pwd, email, mobile_no) values(:username, :userPwd, :email, :mobileNo)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public int delete(long id) {
        String sql = "delete from user where id=:id";
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public int update(User user) {
        String sql = "update user set username=:username and user_pwd=userPwd and email=email and mobile_no=mobileNo";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public User select(long id) {
        String sql = "select * from user where id=:id";
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    public     int deleteByIds(List<Long> ids) {
        String sql = "delete from user where id in (:ids)";
        Map<String, List<Long>> params = new HashMap<>();
        params.put("ids", ids);
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public User verify(Map<String, String> params) {
        String sql = "select * from user where username=:username and user_pwd=:userPwd";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }

    public List<User> listAll() {
        String sql = "select * from user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return namedParameterJdbcTemplate.query(sql, rowMapper);
    }
}
