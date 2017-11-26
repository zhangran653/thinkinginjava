package com.ran.learn.season5;

import java.util.Random;

/**
 * @author zhangran
 * @since 2017-11-26
 **/
public class Worker extends Thread {
    private Channel channel;
    private static final Random random = new Random(System.currentTimeMillis());


    public Worker(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Request request = channel.take();
            request.execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
