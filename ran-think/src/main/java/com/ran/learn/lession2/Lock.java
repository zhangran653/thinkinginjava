package com.ran.learn.lession2;

import java.util.Collection;

/**
 * Created by zhangran on 2017/10/28.
 */
public interface Lock {

    void lock();

    void unlock();

    Collection<Thread> getBlockedThread();

}
