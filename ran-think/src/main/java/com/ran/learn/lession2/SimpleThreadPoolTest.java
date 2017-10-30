package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/29.
 */
public class SimpleThreadPoolTest {
    public static void main(String[] args) throws Exception {
        SimpleThreadPool pool = new SimpleThreadPool();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            pool.addTask(() -> {
                System.out.println(Thread.currentThread().getName() + " ==> is execute  task " + finalI);
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
        pool.addTask(() -> System.out.println("==="));
    }
}
