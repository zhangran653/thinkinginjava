package com.ran.learn.concurrency.chapter09;

public class OtherService {

    private DeadLock deadLock;

    private final Object lock = new Object();

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    public void s1() {
        synchronized (lock) {
            System.out.println("s1=====");
        }
    }

    public void s2() {
        synchronized (lock) {
            System.out.println("s2=====");
            deadLock.m2();
        }
    }

}
