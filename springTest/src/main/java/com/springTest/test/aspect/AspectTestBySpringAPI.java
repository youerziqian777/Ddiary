package com.springTest.test.aspect;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Description 通过spring API来实现切面，只举例前置通知
 * @Date 2023/2/19 18:48
 **/
public class AspectTestBySpringAPI{
    public void before(){
        System.out.println("通过spring API来实现切面 -- 前置通知");
    }
}
