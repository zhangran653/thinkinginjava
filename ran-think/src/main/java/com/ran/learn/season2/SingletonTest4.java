package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/10/30.
 */
public class SingletonTest4 {
    private static volatile SingletonTest4 instance;

    private SingletonTest4() {

    }

    public static SingletonTest4 getInstance() {
        if (null == instance) {
            synchronized (SingletonTest4.class) {
                instance = new SingletonTest4();
            }
        }
        return instance;
    }
}
