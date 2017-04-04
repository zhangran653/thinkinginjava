package com.ran.learn.concurrency.chapter07;

public class ThreadService {

    private Thread executeThread;

    private volatile boolean isFinished = false;

    /**
     * 思路：将任务线程设置为守护线程，执行线程只负责开启任务线程。执行线程需要join，让任务线程执行完成。当需要强行关闭时，由于执行线程此时join，即wait
     * 对其使用interrupt，捕获异常，完成生命周期，任务线程由于是守护线程，自然会关闭。
     * 
     * @param r
     */
    public void execute(Runnable r) {
        executeThread = new Thread() {

            @Override
            public void run() {
                Thread runner = new Thread(r);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    isFinished = true;
                    System.out.println("is finish " + isFinished);
                } catch (InterruptedException e) {
                    System.out.println(
                            "execute thread is interrupted.ready to shutdown.");
                }
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills) {
        long current = System.currentTimeMillis();
        while (!isFinished) {

            if ((System.currentTimeMillis() - current) >= mills) {
                System.out.println("任务超时。");
                executeThread.interrupt();
                break;
            }
        }

        isFinished = false;
    }
}
