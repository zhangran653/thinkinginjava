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
    private static final List<TaskExecutor> TASK_EXECUTORS = new ArrayList<>();
    private static final ThreadGroup THREAD_GROUP = new ThreadGroup("Simple_Threadpool_group");
    private static int TASK_SIZE;
    private static final int TASK_QUEUE_DEFAULT_SIZE = 20;
    private static boolean isShutDown = false;


    public static final DiscardPolicy DEFAULT_POLICY = () -> {
        throw new DiscardException("task size too large.");
    };

    private final DiscardPolicy discardPolicy;

    public SimpleThreadPool() {
        this(DEFAULT_SIZE, TASK_QUEUE_DEFAULT_SIZE, DEFAULT_POLICY);
    }

    public SimpleThreadPool(int size, int taskSize, DiscardPolicy discardPolicy) {
        this.size = size;
        this.TASK_SIZE = taskSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            TaskExecutor taskExecutor = createExecutor();
            TASK_EXECUTORS.add(taskExecutor);
            taskExecutor.start();
        }

    }

    public void addTask(Runnable runnable) throws Exception {
        synchronized (TASK_QUEUE) {
            if (isShutDown) {
                throw new Exception("thread poll is shutdown.");
            }
            if (TASK_QUEUE.size() >= TASK_SIZE) {
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }


    public void shutdown() {
        while (!TASK_QUEUE.isEmpty()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int executors = TASK_EXECUTORS.size();
        while (executors > 0) {
            for (TaskExecutor taskExecutor : TASK_EXECUTORS) {
                if (taskExecutor.getTaskState() == TaskState.BLOCKED) {
                    taskExecutor.interrupt();
                    taskExecutor.shutdown();
                    executors--;
                } else {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        System.out.println("all threads are dead.");
        isShutDown = true;

    }

    private TaskExecutor createExecutor() {
        TaskExecutor executor = new TaskExecutor(THREAD_GROUP, THREAD_PREFIX + (seq++));
        return executor;
    }

    enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private static class TaskExecutor extends Thread {
        private TaskState taskState = TaskState.FREE;

        private TaskExecutor(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }

        public TaskState getTaskState() {
            return taskState;
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
