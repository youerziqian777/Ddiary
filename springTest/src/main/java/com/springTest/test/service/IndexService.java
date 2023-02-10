package com.springTest.test.service;

import com.alibaba.fastjson.JSON;
import com.springTest.test.dao.UserDao1;
import com.springTest.test.dao.UserDao2;
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
    public String test(){
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("set注入",userDao1.getUserName());
        resultMap.put("构造器注入", userDao2.toString());
        return JSON.toJSONString(resultMap);
    }


}
