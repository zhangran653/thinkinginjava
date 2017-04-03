package com.ran.learn.concurrency.chapter07;

public class ThreadClose2 {

    public static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("working...");
                if (this.isInterrupted())
                    break;
            }
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

        w.interrupt();

    }
}
