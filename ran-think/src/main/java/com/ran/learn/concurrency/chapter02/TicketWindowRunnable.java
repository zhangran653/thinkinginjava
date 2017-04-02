package com.ran.learn.concurrency.chapter02;

public class TicketWindowRunnable implements Runnable {
    private final static int MAX = 50;

    private static int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是：" + index++);
        }

    }

}
