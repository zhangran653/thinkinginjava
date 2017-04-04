package com.ran.learn.concurrency.chapter08;

public class Bank3 {

    public static void main(String[] args) {
        final SynchronizedTicketWinowRunnable r = new SynchronizedTicketWinowRunnable();
        Thread t1 = new Thread(r, "一号柜台");
        Thread t2 = new Thread(r, "二号柜台");
        Thread t3 = new Thread(r, "三号柜台");

        t1.start();
        t2.start();
        t3.start();
    }
}
