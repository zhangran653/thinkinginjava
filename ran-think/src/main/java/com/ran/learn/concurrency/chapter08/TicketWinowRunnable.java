package com.ran.learn.concurrency.chapter08;

public class TicketWinowRunnable implements Runnable {
    private final static int MAX = 500;

    private static int index = 1;

    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX) {
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码是：" + index++);
            }

        }

    }

}
