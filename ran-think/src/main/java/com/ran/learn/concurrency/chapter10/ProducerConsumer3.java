package com.ran.learn.concurrency.chapter10;

import java.util.stream.Stream;

public class ProducerConsumer3 {

    private int i;

    private final Object lock = new Object();

    private volatile boolean isFinished = false;

    public void product() {
        synchronized (lock) {
            while (isFinished) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("P-> " + i);
            isFinished = true;
            lock.notifyAll();

        }
    }

    public void consume() {
        synchronized (lock) {
            while (isFinished) {
                System.out.println("c-> " + i);
                isFinished = false;
                lock.notifyAll();
            }
            try {
                lock.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ProducerConsumer3 pc = new ProducerConsumer3();
        Stream.of("p1", "p2", "p3", "p4").forEach(n -> {
            new Thread(n) {
                public void run() {
                    while (true) {
                        pc.product();
                    }
                };
            }.start();
        });

        Stream.of("c1", "c2", "c3", "c4").forEach(n -> {
            new Thread(n) {
                public void run() {
                    while (true) {
                        pc.consume();
                    }
                };
            }.start();
        });
    }
}
