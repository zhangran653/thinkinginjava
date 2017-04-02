package com.ran.learn.concurrency.chapter05;

import java.util.stream.IntStream;

public class ThreadJoin {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out
                    .println(Thread.currentThread().getName() + "->" + i));
        });
        
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000).forEach(i -> System.out
                    .println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        IntStream.range(1, 1000).forEach(i -> System.out
                .println(Thread.currentThread().getName() + "->" + i));
    }
}
