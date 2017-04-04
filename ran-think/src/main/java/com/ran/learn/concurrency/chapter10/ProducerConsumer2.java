package com.ran.learn.concurrency.chapter10;

public class ProducerConsumer2 {

    private int i;

    private final Object lock = new Object();

    private volatile boolean isFinished = false;

    public void product() {
        synchronized (lock) {
            if (isFinished) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("P-> " + i);
                isFinished = true;
                lock.notify();
            }

        }
    }

    public void consume() {
        synchronized (lock) {
            if (isFinished) {
                System.out.println("c-> " + i);
                isFinished = false;
                lock.notify();
            } else {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        ProducerConsumer2 pc = new ProducerConsumer2();
        new Thread("p") {
            public void run() {
                while (true) {
                    pc.product();
                }
            };
        }.start();

        new Thread("c") {
            public void run() {
                while (true) {
                    pc.consume();
                }
            };
        }.start();
    }
}
