package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/25.
 */
public class ThreadClose {

    private static class Worker extends Thread {
        private volatile boolean isShouDown = false;

        @Override
        public void run() {
            while (!isShouDown) {

            }
        }

        public void shutdown(){
            this.isShouDown=true;
        }


    }


    public static void main(String[] args) {
        Worker w = new Worker();
        w.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.shutdown();
    }
}
