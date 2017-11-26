package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/24.
 */
public class CreateThread {

    public static void main(String[] args) {
        Thread t = new Thread();
        Thread t1 = new Thread();
        t.start();
        t1.start();

        System.out.println(t.getName());
        System.out.println(t1.getName());

        Thread t3 = new Thread("Myname");
        Thread t4 = new Thread(()->{
            System.out.println("run ...");

        });
        System.out.println(t3.getName());
        System.out.println(t4.getName());

        Thread t5 = new Thread(()->{
            System.out.println("run ..."+Thread.currentThread().getName());

        },"runable thread");

        t5.start();

    }
}
