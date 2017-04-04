package com.ran.learn.concurrency.chapter09;

public class DeadLockTest {

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread() {
            public void run() {
                while (true) {
                    deadLock.m1();
                }
            };
        }.start();

        new Thread() {
            public void run() {
                while (true) {
                    otherService.s2();
                }
            };
        }.start();
    }
}
