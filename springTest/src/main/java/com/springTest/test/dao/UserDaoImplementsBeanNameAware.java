package com.springTest.test.dao;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImplementsBeanNameAware extends UserDao implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean名称为： " + name);
    }
}
