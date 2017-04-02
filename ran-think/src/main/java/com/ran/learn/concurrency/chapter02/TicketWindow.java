package com.ran.learn.concurrency.chapter02;

public class TicketWindow extends Thread {

    private final String name;

    private final int MAX = 50;

    private int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(name + " 当前的号码是 ：" + (index++));
        }
    }

}
