package com.springTest.test.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class UserDaoImplementsBeanPostProcessor extends UserDao implements BeanPostProcessor {

    //通过BeanPostProcessor前置处理器自定义内容
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)  {
        //默认对所有bean生效，所以需要指定下beanName
        if("userDaoImplementsInitializingBean".equals(beanName)){
            System.out.println("BeanPostProcessor前置处理器--beanName: " + beanName + " ++postProcessBeforeInitialization++ ");
        }
        return bean;
    }

    //通过BeanPostProcessor后置处理器自定义内容
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //默认对所有bean生效，所以需要指定下beanName
        if("userDaoImplementsInitializingBean".equals(beanName)){
            System.out.println("BeanPostProcessor后置处理器--beanName: " + beanName + " ++postProcessAfterInitialization++ ");
        }
        return bean;
    }



}
