package com.springTest.test.aspect;

/**
 * @Description 基于静态代理的AOP实现方式
 * 本质上就是代理对象通过构造方法传入切面类和目标类，最后通过代理对象调用目标类的方法，实现了目标方法 + 增强方法
 * @Date 2023/2/19 21:00
 **/
interface AopBaseOnStaticProxyService{
    void saveUser();
}

//目标类
class AopBaseOnStaticProxyServiceImpl implements AopBaseOnStaticProxyService{

    @Override
    public void saveUser() {
        System.out.println("基于静态代理的AOP实现方式 - 这是目标方法");
    }
}

//切面类，有目标类的增强方法
class AopBaseOnStaticProxyEnhanceService {

    public void enhanceMethod() {
        System.out.println("基于静态代理的AOP实现方式 - 这是切面，是增强方法");
    }
}

//代理类
class AopBaseOnStaticProxyObject{
    private AopBaseOnStaticProxyEnhanceService aopBaseOnStaticProxyEnhanceService;
    private AopBaseOnStaticProxyService aopBaseOnStaticProxyService;

    AopBaseOnStaticProxyObject(AopBaseOnStaticProxyEnhanceService aopBaseOnStaticProxyEnhanceService, AopBaseOnStaticProxyService aopBaseOnStaticProxyService){
        this.aopBaseOnStaticProxyEnhanceService = aopBaseOnStaticProxyEnhanceService;
        this.aopBaseOnStaticProxyService = aopBaseOnStaticProxyService;
    }

    void proxyMethod(){
        aopBaseOnStaticProxyEnhanceService.enhanceMethod();
        aopBaseOnStaticProxyService.saveUser();
    }
}

public class AopBaseOnStaticProxy {
  public static void main(String[] args) {
      AopBaseOnStaticProxyEnhanceService aopBaseOnStaticProxyEnhanceService = new AopBaseOnStaticProxyEnhanceService();
      AopBaseOnStaticProxyService aopBaseOnStaticProxyService = new AopBaseOnStaticProxyServiceImpl();
      AopBaseOnStaticProxyObject aopBaseOnStaticProxyObject = new AopBaseOnStaticProxyObject(aopBaseOnStaticProxyEnhanceService,aopBaseOnStaticProxyService);
      aopBaseOnStaticProxyObject.proxyMethod();
  }
}
