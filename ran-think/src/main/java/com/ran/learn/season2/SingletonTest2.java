package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/10/30.
 */
public class SingletonTest2 {
    private static SingletonTest2 instance;

    private SingletonTest2() {

    }

    public static SingletonTest2 getInstance() {
        if (null == instance) {
            instance = new SingletonTest2();
        }
        return instance;
    }
}
