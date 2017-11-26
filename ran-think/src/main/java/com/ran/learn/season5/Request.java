package com.ran.learn.season5;

/**
 * @author zhangran
 * @since 2017-11-26
 **/
public class Request {

    private final String name;
    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " execute Request" + this.name + ", number is " + number);
    }
}
