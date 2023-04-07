package org.example.clone;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @Description 使用序列化来实现深拷贝
 * Serializable也是标记接口，表示类可以被序列号，writeObject会检查类是否有继承这个接口
 * @Date 2023/3/6 20:04
 **/
class DeepCloneWithSerializableClassChild implements Serializable{
  String name;
  String sex;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}
class DeepCloneWithSerializableClass implements Serializable{
  String grade;
  String level;
  DeepCloneWithSerializableClassChild deepCloneWithSerializableClassChild;

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public DeepCloneWithSerializableClassChild getDeepCloneWithSerializableClassChild() {
    return deepCloneWithSerializableClassChild;
  }

  public void setDeepCloneWithSerializableClassChild(DeepCloneWithSerializableClassChild deepCloneWithSerializableClassChild) {
    this.deepCloneWithSerializableClassChild = deepCloneWithSerializableClassChild;
  }
}

public class DeepCloneWithSerializable {
  static <T extends Serializable> T DeepCloneWithSerializableCopy(T obj) throws IOException, ClassNotFoundException {
    ObjectInputStream objectInputStream = null;
    try {
      //对象转流
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      objectOutputStream.writeObject(obj);

      //流转对象
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
      objectInputStream = new ObjectInputStream(byteArrayInputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return (T) objectInputStream.readObject();
  }
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    DeepCloneWithSerializableClassChild deepCloneWithSerializableClassChild = new DeepCloneWithSerializableClassChild();
    deepCloneWithSerializableClassChild.setName("李二");
    deepCloneWithSerializableClassChild.setSex("男");

    DeepCloneWithSerializableClass deepCloneWithSerializableClass = new DeepCloneWithSerializableClass();
    deepCloneWithSerializableClass.setDeepCloneWithSerializableClassChild(deepCloneWithSerializableClassChild);
    deepCloneWithSerializableClass.setLevel("小学");
    deepCloneWithSerializableClass.setGrade("三年级");
    System.out.println("原类：" + JSON.toJSONString(deepCloneWithSerializableClass));

    DeepCloneWithSerializableClass deepCloneWithSerializableClassCopy = DeepCloneWithSerializableCopy(deepCloneWithSerializableClass);
    System.out.println("复制类：" + JSON.toJSONString(deepCloneWithSerializableClassCopy));

    deepCloneWithSerializableClass.setGrade("四年级");
    deepCloneWithSerializableClassChild.setName("王五");
    deepCloneWithSerializableClass.setDeepCloneWithSerializableClassChild(deepCloneWithSerializableClassChild);
    System.out.println("原类改变后的原类：" + JSON.toJSONString(deepCloneWithSerializableClass));
    System.out.println("原类改变后的复制类：" + JSON.toJSONString(deepCloneWithSerializableClassCopy));
  }
}
