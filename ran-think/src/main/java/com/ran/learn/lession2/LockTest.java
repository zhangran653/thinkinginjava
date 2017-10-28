package com.ran.learn.lession2;

import java.util.stream.Stream;

/**
 * Created by zhangran on 2017/10/28.
 */
public class LockTest {
    public static void main(String[] args) {
        BooleanLock lock = new BooleanLock();
        Stream.of("T1", "T2", "T3", "T4").forEach(name -> new Thread(() -> {
            lock.lock();
            work();
            lock.unlock();
        }, name).start());

    }

    public static void work() {
        System.out.println(Thread.currentThread().getName() + " is working...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
