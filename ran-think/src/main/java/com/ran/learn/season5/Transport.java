package com.ran.learn.season5;

import java.util.Random;

/**
 * @author zhangran
 * @since 2017-11-26
 **/
public class Transport extends Thread {
    private final Channel channel;
    private static final Random random = new Random(System.currentTimeMillis());

    public Transport(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            Request request = new Request(getName(), i);
            channel.put(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
