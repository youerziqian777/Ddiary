package org.example;

/**
 * @ClassNametestMain
 * @Description
 * @Author
 * @Date2023/2/10 18:51
 **/
interface Fruit{
  public void eat();
}

class Apple implements Fruit{

  @Override
  public void eat(){
    System.out.println("Apple");
  }
}
class Factory{
  public static Fruit getInstance(String className) {
    Fruit fruit = null;
    try{
      fruit = (Fruit) Class.forName(className).getDeclaredConstructor().newInstance();
    }catch (Exception e){
      e.printStackTrace();
    }
    return fruit;

  }
}
class Orange implements Fruit{

  @Override
  public void eat() {
    System.out.println("Orange");
  }
}
public class FactoryUnionReflex {
  public static void main(String[] args) {
    //实现工厂 + 反射
    //水果工厂产出苹果和橘子
    Fruit f = Factory.getInstance("org.example.Apple");
    if (f != null){
      f.eat();
    }
  }
}
