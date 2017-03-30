package com.ran.think.concurrency;

public class MainThread {

    /**
     * 实现Runnable类必须具有run方法，但是这个并无特殊之处，它不会产生任何内在的线程能力。要实现线程行为，必须显式的讲一个任务附着到线程上。
     * 
     * @param args
     */
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
