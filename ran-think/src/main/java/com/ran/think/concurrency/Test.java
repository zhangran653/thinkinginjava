package com.ran.think.concurrency;

/**
 * Created by zhangran on 2017/11/2.
 */
public class Test {
    public static void main(String[] args) {
        ThreadLifeCycleListener lifeCycleListener = new ThreadLifeCycleListener();
        ObservableRunnable o1 = new ObservableRunnable(lifeCycleListener) {
            @Override
            public void run() {
                try {
                    notifyObserver(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    Thread.sleep(1000);
                    notifyObserver(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyObserver(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        };
        ObservableRunnable o2 = new ObservableRunnable(lifeCycleListener) {
            @Override
            public void run() {
                try {
                    notifyObserver(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    Thread.sleep(2000);
                    int i = 1 / 0;
                    notifyObserver(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyObserver(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        };
        new Thread(o1, "01").start();
        new Thread(o2, "02").start();


    }
}
