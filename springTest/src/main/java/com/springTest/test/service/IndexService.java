package com.springTest.test.service;

import org.springframework.stereotype.Service;

@Service
public interface IndexService {
    //区分构造注入和set注入
    String test1();

    //基于注解的配置bean
    String test2();

    //bean不配置在xml，而是注解为组件
    String test3();

    //spring内部bean
    String test4();

//    当一个类有多个bean的时候，通过@Qualifier来指定具体用哪个bean
    String test5();

    //报错
    void exception() throws Exception ;

//    使用jdbcTemplate查询数据库
    String jdbcTemplateTest();

    //注入一个 null 和一个空字符串
    void test7();
}
