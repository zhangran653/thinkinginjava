package com.ran.learn.concurrency.chapter07;

public class ThreadClose {

    public static class Worker extends Thread {

        public volatile boolean start = true;

        @Override
        public void run() {
            while (start) {
                System.out.println("working...");
            }
        }

        public void close() {
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker w = new Worker();
        w.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        w.close();

    }
}
