package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/10/30.
 */
public class SingletonTest3 {
    private static SingletonTest3 instance;

    private SingletonTest3() {

    }

    public static SingletonTest3 getInstance() {
        if (null == instance) {
            synchronized (SingletonTest3.class) {
                instance = new SingletonTest3();
            }
        }
        return instance;
    }
}
