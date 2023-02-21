package com.springTest.test.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description 使用JdbcTemplate连接数据库
 * @Date 2023/2/21 15:43
 **/
@Repository
public class JdbcTemplateTestMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getPassword(String userName){
        String sql ="select password from user where username=?";
        return jdbcTemplate.queryForObject(sql ,String.class,userName);
    }
}
