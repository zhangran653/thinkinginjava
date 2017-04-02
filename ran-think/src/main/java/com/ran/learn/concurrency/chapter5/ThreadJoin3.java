package com.ran.learn.concurrency.chapter5;

public class ThreadJoin3 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new Machine("M1", 1000L));
        Thread t2 = new Thread(new Machine("M2", 1500L));
        Thread t3 = new Thread(new Machine("M3", 1800L));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("start at " + start + " and end at " + end);
    }

}
