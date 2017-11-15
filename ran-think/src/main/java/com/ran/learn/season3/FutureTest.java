package com.ran.learn.season3;

/**
 * Created by zhangran on 2017/11/16.
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException {
        FutureService service = new FutureService();
        Future<String> future = service.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "done";
        });

        System.out.println("============");

        System.out.println(future.get());

    }
}
