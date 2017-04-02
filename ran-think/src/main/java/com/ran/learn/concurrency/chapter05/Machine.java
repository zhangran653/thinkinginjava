package com.ran.learn.concurrency.chapter05;

import java.util.concurrent.TimeUnit;

public class Machine implements Runnable {
    private String machineName;

    private long time;

    public Machine(String machineName, long time) {
        this.machineName = machineName;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(machineName + " is running...");
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(machineName + " is done.");
    }
}
