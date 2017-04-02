package com.ran.learn.concurrency.chapter02;

public class Bank {

    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("一号柜台");
        t1.start();
    }
}
