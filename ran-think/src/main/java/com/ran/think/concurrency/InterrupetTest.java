package com.ran.think.concurrency;

/**
 * @author
 * @create 2017-11-22 下午10:45
 **/
public class InterrupetTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println(t.isInterrupted());
    }
}
