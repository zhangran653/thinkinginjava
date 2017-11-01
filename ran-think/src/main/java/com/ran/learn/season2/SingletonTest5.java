package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/10/30.
 */
public class SingletonTest5 {
    private static volatile SingletonTest5 instance;

    private SingletonTest5() {

    }


    private static class InstanceHolder {
        private static final SingletonTest5 instance = new SingletonTest5();
    }

    public static SingletonTest5 getInstance() {
        return InstanceHolder.instance;
    }
}
