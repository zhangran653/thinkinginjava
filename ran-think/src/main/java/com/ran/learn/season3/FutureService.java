package com.ran.learn.season3;

/**
 * Created by zhangran on 2017/11/16.
 */
public class FutureService {
    public <T> Future<T> submit(FutureTask<T> task) {
        AsyncFutureTask<T> asyncFutureTask = new AsyncFutureTask<>();
        new Thread(() -> {
            asyncFutureTask.done(task.call());
        }).start();
        return asyncFutureTask;

    }
}
