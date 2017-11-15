package com.ran.learn.season3;

/**
 * Created by zhangran on 2017/11/16.
 */
public class AsyncFutureTask<T> implements Future<T> {

    private volatile boolean isDone;
    private T result;

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!isDone) {
                this.wait();
            }
            return result;
        }

    }


    public void done(T result) {
        synchronized (this) {
            isDone = true;
            this.result = result;
            this.notifyAll();
        }

    }


}
