package com.ran.learn.concurrency.chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("--");
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
