package com.springTest.test.serviceImpl;

import com.springTest.test.service.PostConstructAndPreDestroyTestService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description 测试注解@PreDestroy、@PostConstruct
 * @Date 2023/2/21 22:07
 **/
@Service
public class PostConstructAndPreDestroyTestServiceImpl implements PostConstructAndPreDestroyTestService {
    @Override
    public void test() {
        System.out.println("测试注解@PostConstruct和@PreDestroy");
    }

    @PreDestroy
    public void testPreDestroy(){
        System.out.println("bean生命周期-销毁-注解方式-@PreDestroy-对应xml配置destroy-method");
    }

    @PostConstruct
    public void testPostConstruct(){
        System.out.println("bean生命周期-init-注解方式-@PostConstruct-对应xml配置init-method");
    }
}
