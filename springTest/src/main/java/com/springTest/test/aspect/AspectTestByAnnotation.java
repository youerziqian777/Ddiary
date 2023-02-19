package com.springTest.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description 通过注解来实现切面例子
 * 如果要正常返回，可以访问http://localhost:8080/springTest/app/test1
 * 如果要异常返回，可以访问http://localhost:8080/springTest/app/exception
 * @Date 2023/2/16 20:43
 **/
@Aspect
@Component
//切面本身得是一个bean
public class AspectTestByAnnotation {
    @Before("execution(* com.springTest.test.service.IndexService.test1(..))")
    //execution匹配的就是pointcut，@Before、@After这些就是advice
    public void aspectTestBefore(){
        System.out.println("切面@Before - 在连接点之前执行的通知");
    }

    @After("execution(* com.springTest.test.service.IndexService.test1(..))")
    public void aspectTestAfter(){
        System.out.println("切面@After - 不管是异常退出还是正常返回，都在连接点之后执行的通知");
    }

    @AfterReturning("execution(* com.springTest.test.service.IndexService.test1(..))")
    public void aspectTestAfterReturning(){
        System.out.println("切面@AfterReturning - 正常返回后执行的通知");
    }

    @AfterThrowing("execution(* com.springTest.test.service.IndexService.exception(..))")
    public void aspectTestAfterThrowing(){
        System.out.println("切面@AfterThrowing - 异常退出后执行的通知");
    }

    @Around("execution(* com.springTest.test.service.IndexService.test1(..))")
    public Object aspectTestAround(ProceedingJoinPoint point) throws Throwable {
        //参数必须有ProceedingJoinPoint，用于执行目标方法
        //返回值必须有Object类型，用于返回目标方法的结果
        System.out.println("切面@Around - 在连接点之前和之后执行");
        //获取目标方法的参数
        Object[] args =  point.getArgs();
        //获取目标方法的名称
        String methodName = point.getSignature().getName();
        // 打印日志：开始执行某个方法
        System.out.println("开始执行" + methodName + "方法，参数为：" + Arrays.toString(args));
        // 执行目标方法，并获取返回值
        Object result = point.proceed(args);
        // 打印日志：结束执行某个方法
        System.out.println("结束执行" + methodName + "方法，返回值为：" + result);
        // 返回目标方法的结果
        return result;
    }
}
