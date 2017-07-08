package com.ran.learn.thread.lession01;

/**
 * Created by zhangran on 2017/7/8.
 */
public class Bank {

    public static void main(String[] args) {
        final TicketWindow ticketWindow = new TicketWindow();
        Thread t1 = new Thread(ticketWindow, "一号柜台");
        Thread t2 = new Thread(ticketWindow, "二号柜台");
        Thread t3 = new Thread(ticketWindow, "三号柜台");

        t1.start();
        t2.start();
        t3.start();
    }
}
