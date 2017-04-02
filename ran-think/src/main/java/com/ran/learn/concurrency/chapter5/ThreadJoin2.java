package com.ran.learn.concurrency.chapter5;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadJoin2 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                System.out.println("t1 is running");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("t1 is done");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });

        t.start();
        try {
            t.join(1900);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        IntStream.range(1, 1000).forEach(i -> System.out
                .println(Thread.currentThread().getName() + "->" + i));
    }
}
