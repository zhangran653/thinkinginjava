package com.ran.learn.concurrency.chapter08;

public class SynchronizedTicketWinowRunnable implements Runnable {
    private final static int MAX = 500;

    private static int index = 1;

    @Override
    public synchronized void run() {
        while (true) {

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
