package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/11/2.
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    public abstract void update();

}
