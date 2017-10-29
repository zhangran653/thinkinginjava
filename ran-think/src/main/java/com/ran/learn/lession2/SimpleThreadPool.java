package com.ran.learn.lession2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangran on 2017/10/29.
 */
public class SimpleThreadPool {

    private final int size;
    private final static int DEFAULT_SIZE = 10;
    private static final LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";
    private static volatile int seq = 0;
    private static final List<Thread> TASK_EXECUTORS = new ArrayList<>();
    private static final ThreadGroup THREAD_GROUP = new ThreadGroup("Simple_Threadpool_group");

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            TaskExecutor taskExecutor = createExecutor();
            TASK_EXECUTORS.add(taskExecutor);
            taskExecutor.start();
        }

    }

    public void addTask(Runnable runnable) {
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private TaskExecutor createExecutor() {
        TaskExecutor executor = new TaskExecutor(THREAD_GROUP, THREAD_PREFIX + (seq++));
        return executor;
    }

    enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private class TaskExecutor extends Thread {
        private TaskState taskState = TaskState.FREE;

        private TaskExecutor(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }


        public void run() {
            OUTER:
            while (taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                taskState = TaskState.RUNNING;
                runnable.run();
                taskState = TaskState.FREE;

            }

        }

        public void shutdown() {
            taskState = TaskState.DEAD;
        }
    }

}
