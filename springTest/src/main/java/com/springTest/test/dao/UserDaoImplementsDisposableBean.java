package com.springTest.test.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImplementsDisposableBean extends UserDao implements DisposableBean {
    //当容器关闭时，做清理
    @Override
    public void destroy() {
        System.out.println("清理--UserDaoImplementsDisposableBean 当容器关闭时，做清理");
    }
}
