package com.springTest.test.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.springTest.test.dao.*;
import com.springTest.test.mapper.JdbcTemplateTestMapper;
import com.springTest.test.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    UserDao1 userDao1;

    @Autowired
    UserDao2 userDao2;

    @Autowired
    UserDao3 userDao3;

    @Autowired
    @Qualifier("articleContentShowDao")
    ArticleShowDao articleShowDao;

    @Autowired
    @Qualifier("userDaoTestQualifier2")
    UserDaoTestQualifier userDaoTestQualifier;

    @Autowired
    JdbcTemplateTestMapper jdbcTemplateTestMapper;

    @Autowired
    @Qualifier("autowiredNull")
    ArticleShowDao autowiredNull;

    //区分构造注入和set注入
    public String test1(){
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("set注入",userDao1.getUserName());
        resultMap.put("构造器注入", userDao2.toString());
        return JSON.toJSONString(resultMap);
    }

    //基于注解的配置bean
    public String test2(){
        userDao3.setUserName("王五");
        return userDao3.getUserName();
    }

    //bean不配置在xml，而是注解为组件
    public String test3(){
        userDao3.setUserName("王五");
        return userDao3.getUserName();
    }

    //spring内部bean
    public String test4(){
        ArticleContentDao articleContentDao = articleShowDao.getArticleContentDao();
        articleContentDao.setText("111111");
        articleShowDao.setArticleContentDao(articleContentDao);
        return articleShowDao.getArticleContentDao().getText();
    }

    //    当一个类有多个bean的时候，通过@Qualifier来指定具体用哪个bean
    public String test5(){
        userDaoTestQualifier.setUserName("userDaoTestQualifier2");
        return userDaoTestQualifier.getUserName();
    }

    //报错
    public void exception() throws Exception {
        throw new Exception();
    }

    //    使用jdbcTemplate查询数据库
    public String jdbcTemplateTest() {
        return jdbcTemplateTestMapper.getPassword("犁牛");
    }

    //注入一个 null 和一个空字符串
    @Override
    public void test7() {
        if(autowiredNull.getArticleContentDao() == null){
            System.out.println("对象为空");
        }
        if("".equals(autowiredNull.getTitle()) || (autowiredNull.getTitle() == null)){
            System.out.println("字符串为空");
        }
    }
}
