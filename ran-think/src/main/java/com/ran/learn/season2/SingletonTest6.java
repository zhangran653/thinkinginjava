package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/10/30.
 */
public class SingletonTest6 {
    private static volatile SingletonTest6 instance;

    private SingletonTest6() {

    }

    private enum Instance {
        INSTANCE;

        private final SingletonTest6 instance;

        private Instance() {
            instance = new SingletonTest6();
        }

        private SingletonTest6 getInstance() {
            return instance;
        }

    }

    public static SingletonTest6 getInstance() {
        return Instance.INSTANCE.getInstance();
    }


}
