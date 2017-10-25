package com.ran.learn.lession2;

import java.util.Objects;

/**
 * Created by zhangran on 2017/10/25.
 */
public class ThreadInterrupt {

    private static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread() {
//
//            @Override
//            public void run() {
//                while (true) {
////                    System.out.println("===" + this.isInterrupted());
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        System.out.println("收到打断信号");
////                        e.printStackTrace();
////                    }
//                    synchronized (object){
//                        try {
//                            object.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//
//                }
//            }
//        };
//
//        t.start();
//        Thread.sleep(100);
//
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());

        Thread t = new Thread(){
            @Override
            public void run() {
                while (true){

                }
            }
        };
        Thread main = Thread.currentThread();
        t.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("interrupt");
            }
        };
        t2.start();

        try {
            t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
