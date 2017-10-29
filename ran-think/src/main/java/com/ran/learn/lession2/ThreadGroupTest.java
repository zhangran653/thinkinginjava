package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/29.
 */
public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg1, () -> {
            while (true) {
                try {
                    System.out.println("t1...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("t1 interrupted");
                    break;
                }
            }

        });

        t1.start();



        ThreadGroup tg2 = new ThreadGroup(tg1, "tg1");
        Thread t2 = new Thread(tg2, () -> {
            while (true) {
                try {
                    System.out.println("t2...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("t2 interrupted");
                    break;
                }
            }

        });

        t2.start();


        System.out.println(t1.getThreadGroup().getName());
        System.out.println(tg1.getName());
        System.out.println(tg1.activeCount());

        System.out.println(t2.getThreadGroup().getName());
        System.out.println(tg2.getName());
        System.out.println(tg2.activeCount());

        tg1.interrupt();

    }
}
