package com.ran.learn.concurrency.chapter03;

public class CreateThread {

    public static void main(String[] args) {
        /**
         * 1.创建Thread对象，默认构造器new Thread(),默认有一个name，已Thread-开头，从0开始计数 . Thread-0
         * Thread-1 Thread-2
         * 
         */
        Thread t1 = new Thread();
        /**
         * 2.如果构造Thread没有传Runnable接口或者没有覆写run方法，则不执行任何东西。反之执行逻辑
         *
         */
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("============");
            }
        };
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());

        Thread t3 = new Thread("MyThraed");
        Thread t4 = new Thread(() -> System.out.println("Runnable..."));

        t3.start();
        t4.start();

        System.out.println(t3.getName());
        System.out.println(t4.getName());

        Thread t5 = new Thread(() -> System.out.println("Runnable...." + Thread.currentThread().getName()),
                "RunnableThread");
        t5.start();
        System.out.println(t5.getName());
    }
}
