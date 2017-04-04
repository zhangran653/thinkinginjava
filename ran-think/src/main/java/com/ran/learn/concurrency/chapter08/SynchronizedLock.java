package com.ran.learn.concurrency.chapter08;

public class SynchronizedLock {

    public static void main(String[] args) {
        ThisLock l1 = new ThisLock();
        Thread t1 = new Thread("T1") {
            @Override
            public void run() {
                l1.m1();
            }
        };
        t1.start();
        Thread t2 = new Thread("T2") {
            @Override
            public void run() {
                l1.m2();
            }

        };
        t2.start();
    }

    public static class ThisLock {

        private final Object MONITOR = new Object();

        public synchronized void m1() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void m2() {
            synchronized (MONITOR) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

}
