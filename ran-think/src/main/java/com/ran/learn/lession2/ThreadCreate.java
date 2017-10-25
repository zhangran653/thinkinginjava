package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/24.
 */
public class ThreadCreate {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        System.out.println(t.getThreadGroup());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());


    }
}
