package com.ran.learn.concurrency.chapter06;

public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                // try {
                System.out.println(i);
                // TimeUnit.MILLISECONDS.sleep(200);
                // } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
                System.out.println(Thread.currentThread().isAlive());
            }
            System.out.println(Thread.currentThread().isAlive());
        });
        t.start();

        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
        while (true) {
            System.out.println(t.isAlive());
        }
    }
}
