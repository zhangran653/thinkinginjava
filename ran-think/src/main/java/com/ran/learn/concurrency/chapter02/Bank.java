package com.ran.learn.concurrency.chapter02;

public class Bank {

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("一号柜台");
        t1.start();

        TicketWindow t2 = new TicketWindow("二号柜台");
        t2.start();

        TicketWindow t3 = new TicketWindow("三号柜台");
        t3.start();
    }
}
