package com.ran.learn.concurrency.chapter07;

public class ThreadCloseForce {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ThreadService t = new ThreadService();

        t.execute(() -> {
            long c = System.currentTimeMillis();
            while (System.currentTimeMillis() - c < 6000) {

            }
            System.out.println("task finished");

        });
        t.shutdown(5000);
        long end = System.currentTimeMillis();
        System.out.println("running time:" + (end - start));
    }

}
