package com.ran.think.concurrency;

/**
 * Created by zhangran on 2017/11/2.
 */
public class ThreadLifeCycleListener implements LifeCycleListener {
    private final Object lock = new Object();


    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (lock) {
            System.out.println(event.getThread().getName() + ", state" + event.getState());
            if (event.getThrowable() != null) {
                System.out.println("error!");
                event.getThrowable().printStackTrace();
            }
        }
    }
}
