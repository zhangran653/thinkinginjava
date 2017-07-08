package com.ran.learn.thread.lession01;

/**
 * Created by zhangran on 2017/7/8.
 */
public class TicketWindow implements Runnable {

    private int index = 1;

    private final int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + " 的号是：" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
