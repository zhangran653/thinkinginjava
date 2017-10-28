package com.ran.learn.lession2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by zhangran on 2017/10/28.
 */
public class BooleanLock implements Lock {
    //false free,true locked
    private boolean initValue;

    private Collection<Thread> blockedCollection = new ArrayList<>();

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() {
        while (initValue) {
            try {
                this.wait();
                blockedCollection.add(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.initValue = true;
        blockedCollection.remove(Thread.currentThread());

    }

    @Override
    public synchronized void unlock() {
        initValue = false;
        System.out.println(Thread.currentThread().getName() + " release the lock.");
        this.notifyAll();
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(this.blockedCollection);
    }
}
