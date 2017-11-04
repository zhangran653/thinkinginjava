package com.ran.think.concurrency;

/**
 * Created by zhangran on 2017/11/2.
 */
public abstract class ObservableRunnable implements Runnable {
    protected LifeCycleListener listener;

    public ObservableRunnable(final LifeCycleListener lifeCycleListener) {
        this.listener = lifeCycleListener;

    }

    public void notifyObserver(RunnableEvent event) {
        listener.onEvent(event);
    }


    public enum RunnableState {
        RUNNING, DONE, ERROR;
    }

    public static class RunnableEvent {
        private RunnableState state;
        private Thread thread;
        private Throwable throwable;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.throwable = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public void setState(RunnableState state) {
            this.state = state;
        }

        public Thread getThread() {
            return thread;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public void setThrowable(Throwable throwable) {
            this.throwable = throwable;
        }
    }

}
