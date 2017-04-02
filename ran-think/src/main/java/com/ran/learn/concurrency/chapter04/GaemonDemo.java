package com.ran.learn.concurrency.chapter04;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class GaemonDemo {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {

            try {
                System.out.println(Thread.currentThread().getName() + "start...");
                TimeUnit.SECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + "end.....");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        t.setDaemon(true);
        t.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName());

    }

}
