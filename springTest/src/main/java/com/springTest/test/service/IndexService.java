package com.springTest.test.service;

import com.alibaba.fastjson.JSON;
import com.springTest.test.dao.UserDao1;
import com.springTest.test.dao.UserDao2;
import com.springTest.test.dao.UserDao3;
import com.springTest.test.dao.UserDaoImplementsBeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IndexService {
    @Autowired
    UserDao1 userDao1;

    @Autowired
    UserDao2 userDao2;

    @Autowired
    UserDao3 userDao3;

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

}
