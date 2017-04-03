package com.ran.learn.concurrency.chapter06;

public class ThreadInterrupt3 {

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run() {
                try {
                    long time = System.currentTimeMillis();
                    while (System.currentTimeMillis() - time < 2000) {
                    }
                    System.out.println("A1");
                } catch (Exception e) {
                    System.out.println("B1");
                }
            }
        };
        thread1.start();
        thread1.interrupt();

        // A1

        // 在线程sleep状态下进行中断
        Thread thread2 = new Thread() {
            @SuppressWarnings("static-access")
            public void run() {
                try {
                    this.sleep(2000);
                    System.out.println("A2");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("B2");
                }
            }

        };

        thread2.start();
        thread2.interrupt();

        // B2

        // 在线程wait状态下进行中断,其中wait()没有在同步块中
        Thread thread3 = new Thread() {
            public void run() {
                try {
                    this.wait(2000);
                    System.out.println("A3");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("B3");
                }
            }

        };

        thread3.start();
        thread3.interrupt();

        // B3

        /**
         * wait() & interrupt() 线程A调用了wait()进入了等待状态,也可以用interrupt()取消.
         * 不过这时候要小心锁定的问题.线程在进入等待区,会把锁定解除,当对等待中的线程调用interrupt()时
         * ,会先重新获取锁定,再抛出异常.在获取锁定之前,是无法抛出异常的.
         */

        // 在线程wait状态下进行中断,其中wait()在同步块中
        Thread thread4 = new Thread() {
            public void run() {
                try {
                    synchronized (this) {
                        this.wait(2000);
                        System.out.println("A4");
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("B4");
                }
            }

        };

        thread4.start();
        thread4.interrupt();

        // B4

        try {
            thread4.start();
            System.out.println("A5");
        } catch (Exception e) {
            System.out.println("B5");
            System.out.println(e.toString());
        }

        // B5

    }
}
