package com.ran.learn.season4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author zhangran
 * @since 2017/11/25
 **/
public class CountdownLatchTest {
    private static final CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 5).forEach(i -> {
            executorService.submit(() -> {

                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "  " + i);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        });
        executorService.shutdown();
        countDownLatch.await();
        System.out.println("All task finished");
    }
}
