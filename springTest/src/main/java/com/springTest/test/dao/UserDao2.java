package com.springTest.test.dao;


public class UserDao2 {
    private int id;
    private final String userName; // 用户名
    private String sex; // 性别
    private String age; // 年龄
    private String address; // 家庭地址
    private String password; //密码
    public UserDao2(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDao2{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
