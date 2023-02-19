package com.springTest.test.aspect;


import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description 基于动态代理的AOP实现方式
 * 本质上是代理类通过反射调用了切面类和目标类，最后通过代理对象调用目标类的方法，实现了目标方法 + 增强方法
 * @Date 2023/2/19 21:21
 **/
//目标类
interface AopBaseOnDynamicProxyTarget{
    void targetMethod();
}
//目标实现类
class AopBaseOnDynamicProxyTargetImpl implements AopBaseOnDynamicProxyTarget{
    @Override
    public void targetMethod(){
        System.out.println("基于动态代理的AOP实现方式 - 这是目标方法");
    }
}
//切面类
class AopBaseOnDynamicProxyAspect{
    public void before(){
        System.out.println("基于动态代理的AOP实现方式 - 这是切面，是增强方法");
    }
}
//代理类
class AopBaseOnDynamicProxyObject implements InvocationHandler{
    private Object target;
    private Object aspect;

    AopBaseOnDynamicProxyObject(Object target,Object aspect){
        this.target = target;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //实现切面方法
        Method beforeMethod = aspect.getClass().getMethod("before");
        beforeMethod.invoke(aspect);
        //实现目标方法
        Object result = method.invoke(target,args);
        return result;
    }
}

public class AopBaseOnDynamicProxy {
  public static void main(String[] args){
      try {
          //创建目标类
          AopBaseOnDynamicProxyTarget target = new AopBaseOnDynamicProxyTargetImpl();
          //创建切面类
          AopBaseOnDynamicProxyAspect aspect = new AopBaseOnDynamicProxyAspect();
          //创建代理类
          AopBaseOnDynamicProxyObject proxy = new AopBaseOnDynamicProxyObject(target,aspect);
          //初始化代理类
          AopBaseOnDynamicProxyTarget targetProxy = (AopBaseOnDynamicProxyTarget) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                  target.getClass().getInterfaces(),
                  proxy);
          targetProxy.targetMethod();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

}
