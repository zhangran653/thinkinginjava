package com.ran.learn.season4;

/**
 * @author zhangran
 * @since 2017/11/25
 **/
public class CountDown {
    private final int total;
    private int count = 0;

    public CountDown(int count) {
        this.total = count;
    }

    public void countDown() {
        synchronized (this) {
            count++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (count != total) {
                this.wait();
            }
        }
    }

}
