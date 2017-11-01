package com.ran.learn.season2;

/**
 * Created by zhangran on 2017/11/2.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver observer = new BinaryObserver(subject);

        subject.setState(3);

        subject.setState(4);

        subject.setState(4);
    }
}
