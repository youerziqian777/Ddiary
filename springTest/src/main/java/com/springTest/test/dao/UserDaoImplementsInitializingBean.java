package com.springTest.test.dao;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class UserDaoImplementsInitializingBean extends UserDao implements InitializingBean {
    @Override
    public void afterPropertiesSet(){
        System.out.println("初始化--bean充填属性后，会执行我");
    }

    //表示在afterPropertiesSet后执行方法为init的方法
    @Bean(initMethod = "initCode")
    public UserDaoImplementsInitializingBean iUserDaoImplementsInitializingBean(){
        return new UserDaoImplementsInitializingBean();
    }

    public void initCode(){
        System.out.println("初始化--用代码指定自定义初始化方法，afterPropertiesSet后，会执行我");
    }

    public void init(){
        System.out.println("初始化--用配置指定自定义初始化方法，afterPropertiesSet后，会执行我");
    }




}
