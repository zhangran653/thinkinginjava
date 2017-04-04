package com.ran.learn.concurrency.chapter07;

public class ThreadService {

    private Thread executeThread;

    private volatile boolean isFinished = false;

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
