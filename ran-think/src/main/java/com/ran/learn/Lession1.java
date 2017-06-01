package com.ran.learn;

import java.util.concurrent.TimeUnit;

/**
 * 
 *
 * @author zhangran
 * @since 2017年5月29日
 */
public class Lession1 {

    public static void main(String[] args) throws Exception {

        new Thread("t1") {
            @Override
            public void run() {
                try {
                    taskA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("t2") {
            @Override
            public void run() {
                try {
                    taskB();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private static void taskA() throws Exception {
        System.out.println("start doing task A.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("task A complete");
    }

    private static void taskB() throws Exception {
        System.out.println("start doing task B.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("task B complete");
    }
}
