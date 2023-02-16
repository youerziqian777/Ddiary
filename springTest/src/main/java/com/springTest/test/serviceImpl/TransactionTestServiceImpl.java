package com.springTest.test.serviceImpl;

import com.springTest.test.dao.UserDao1;
import com.springTest.test.service.TransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 声明式事务管理
 * @Date 2023/2/16 12:29
 **/
@Service
@Transactional
public class TransactionTestServiceImpl implements TransactionTestService {
    @Autowired
    UserDao1 userDao1;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String getId() {
        //其实是应该连接数据库的，例子写的不好，没有体现事务的作用
        userDao1.setId(5);
        return Integer.toString(userDao1.getId());
    }
}
