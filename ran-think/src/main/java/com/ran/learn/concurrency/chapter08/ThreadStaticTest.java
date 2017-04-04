package com.ran.learn.concurrency.chapter08;

public class ThreadStaticTest {
    public static void main(String[] args) {
        
        Thread t1 = new Thread("T1") {
            @Override
            public void run() {
                SynchronizedStatic.m1();
            }
        };
        t1.start();
        Thread t2 = new Thread("T2") {
            @Override
            public void run() {
                SynchronizedStatic.m2();
            }

        };
        t2.start();
    }

}
