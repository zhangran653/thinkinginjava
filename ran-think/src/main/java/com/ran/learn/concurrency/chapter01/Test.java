package com.ran.learn.concurrency.chapter01;

public class Test {


    public synchronized void m() {
        int count = 0;
        while (true) {
            count++;
            System.out.println(count);
            if (count == 100) {
                try {
                    System.out.println("=====");
                    this.wait();
                    System.out.println("after wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(count>100){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public synchronized void keep() {
        System.out.println("notify");
        this.notifyAll();

    }


    public static void main(String[] args) {
        Test m = new Test();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            m.keep();
        }).start();
        m.m();

    }
}
