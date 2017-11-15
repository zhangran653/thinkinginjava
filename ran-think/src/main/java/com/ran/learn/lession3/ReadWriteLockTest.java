package com.ran.learn.lession3;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by zhangran on 2017/11/15.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReadWriteLock();
        SharedData data = new SharedData('*');

        IntStream.range(0, 10).forEach(i -> {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        lock.readLock();
                        System.out.println(Thread.currentThread().getName() + " " + data.readData());
                        lock.readUnlock();
                        Thread.sleep(10);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "Thread read" + i);
            t.start();
        });

        IntStream.range(0, 10).forEach(i -> {
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        lock.writeLock();
                        data.writeData(randomChar());
                        lock.writeUnlock();
                        Thread.sleep(10);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "Thread write" + i);
            t.start();
        });
    }

    private synchronized static char randomChar() {
        Random r = new Random();
        int i = r.nextInt(10);
        return (char) (i + 118);
    }
}
