package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/11/2.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
        subject.attach(this);
    }


    @Override
    public void update() {
        System.out.println("BinaryObserver " + Integer.toBinaryString(subject.getState()));
    }
}
