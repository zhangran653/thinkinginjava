package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/10/30.
 */
public class SingletonTest {
    private static SingletonTest instanse = new SingletonTest();

    private SingletonTest() {

    }

    public static SingletonTest getInstanse() {
        return instanse;
    }
}
