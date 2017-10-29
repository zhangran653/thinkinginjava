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

    private Thread currentThread;

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() {
        while (initValue) {
            try {
                System.out.println(Thread.currentThread().getName()+" is waiting...");
                blockedCollection.add(Thread.currentThread());
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.initValue = true;
        blockedCollection.remove(Thread.currentThread());
        this.currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void unlock() {
        if (this.currentThread == Thread.currentThread()) {
            initValue = false;
            System.out.println(Thread.currentThread().getName() + " release the lock.");
            this.notifyAll();
        }

    }

    @Override
    public synchronized void lock(long mills) {
        if (mills <= 0) {
            lock();
        }

        while (initValue) {
            try {
                blockedCollection.add(Thread.currentThread());
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.initValue = true;
        blockedCollection.remove(Thread.currentThread());
        this.currentThread = Thread.currentThread();
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(this.blockedCollection);
    }
}
