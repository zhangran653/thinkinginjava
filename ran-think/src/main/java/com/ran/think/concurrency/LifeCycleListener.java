package com.ran.think.concurrency;

/**
 * Created by zhangran on 2017/11/2.
 */
public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent event);


}
