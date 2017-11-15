package com.ran.learn.season3;

/**
 * Created by zhangran on 2017/11/16.
 */
public interface Future<T> {

    T get() throws InterruptedException;
}
