package com.ran.learn.concurrency.chapter03;

import java.util.Arrays;

public class ThreadCreate2 {

    public static void main(String[] args) {
        /**
         * 如果构造宪线程对象时没传入ThreadGroup，Thread会默认获取父线程的ThreadGroup。此时子线程和父线程在一个ThreadGroup中。
         */
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        t1.start();

        // System.out.println(t1.getThreadGroup());
        // System.out.println(Thread.currentThread().getName());
        // System.out.println(Thread.currentThread().getThreadGroup().getName());

        ThreadGroup tg = Thread.currentThread().getThreadGroup();

        System.out.println(tg.activeCount());
        Thread[] ts = new Thread[tg.activeCount()];
        tg.enumerate(ts);
        Arrays.asList(ts).forEach(System.out::println);
    }
}
