package com.ran.learn.concurrency.chapter10;

public class DifferenceOfWaitAndSleep {

    private static final byte[] lock = new byte[0];

    public static void main(String[] args) {
        m1();
        m2();
    }

    public static void m1() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void m2() {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
