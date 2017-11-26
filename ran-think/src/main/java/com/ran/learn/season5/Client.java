package com.ran.learn.season5;

/**
 * @author zhangran
 * @since 2017-11-26
 **/
public class Client {

    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorkers();

        new Transport("t1", channel).start();
        new Transport("t2", channel).start();
        new Transport("t3", channel).start();


    }
}
