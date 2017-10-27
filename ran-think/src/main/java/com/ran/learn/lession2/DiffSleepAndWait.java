package com.ran.learn.lession2;

import java.util.stream.Stream;

/**
 * Created by zhangran on 2017/10/27.
 */
public class DiffSleepAndWait {

    private final static Object lock = new Object();

    public static void main(String[] args) {
        Stream.of("t1", "t2").forEach(name -> new Thread(name) {
            @Override
            public void run() {
                m2();
            }
        }.start());
    }

    public static void m1() {
        synchronized (lock) {
            try {
                System.out.println("m1====" + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void m2() {
        synchronized (lock) {
            try {
                System.out.println("m1====" + Thread.currentThread().getName());
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
