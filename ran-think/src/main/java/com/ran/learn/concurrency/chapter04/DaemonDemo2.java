package com.ran.learn.concurrency.chapter04;

import java.util.concurrent.TimeUnit;

public class DaemonDemo2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Thread inner = new Thread(() -> {
                while (true) {
                    System.out.println("do something...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            inner.setDaemon(false);
            inner.start();
        });
        t1.setDaemon(true);

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
