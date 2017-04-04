package com.ran.learn.concurrency.chapter10;

public class ProducerConsumer {

    private int i;

    private final Object lock = new Object();

    public void product() {
        synchronized (lock) {
            System.out.println("P-> " + i++);
        }
    }

    public void consume() {
        synchronized (lock) {
            System.out.println("c-> " + i);
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
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
