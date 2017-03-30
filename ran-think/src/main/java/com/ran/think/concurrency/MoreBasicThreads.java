package com.ran.think.concurrency;

/**
 * 
 * @author zr
 *
 */
public class MoreBasicThreads {

    /**
     * 每个Thread都注册了自己，因此确实有一个对他的引用，而且在他的任务退出run()并死亡之前，垃圾回收器无法回收它。
     * 
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new LiftOff());
            t.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
