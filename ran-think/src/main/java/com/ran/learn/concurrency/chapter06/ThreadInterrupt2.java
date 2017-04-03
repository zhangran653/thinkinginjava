package com.ran.learn.concurrency.chapter06;

public class ThreadInterrupt2 {

    public static void main(String[] args) {
        /**
         * interrupt()只是改变中断状态而已.
         * interrupt()不会中断一个正在运行的线程。这一方法实际上完成的是，给受阻塞的线程抛出一个中断信号，
         * 这样受阻线程就得以退出阻塞的状态
         */
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                boolean isStop = false;
                while (!isStop) {

                    System.out.println(getName() + " is running..."
                            + "  isInterrupted :" + this.isInterrupted());
                    long time = System.currentTimeMillis();
                    while (System.currentTimeMillis() - time < 2000) {
                    }
                    if (this.isInterrupted()) {
                        try {
                            /**
                             * 注意1:如果线程被调用了interrupt()，那么如果此次该线程并不在wait(),sleep(),join()时，
                             * 下次执行wait(),sleep(),join()时，一样会抛出InterruptedException，当然抛出后该线程的中断状态也回被系统复位。
                             */
                            long time1 = System.currentTimeMillis();
                            while (System.currentTimeMillis() - time1 < 2000) {
                            }
                            System.out.println("====================");
                            Thread.sleep(1000);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("===========" + getName()
                                    + "  isInterrupted :"
                                    + this.isInterrupted());
                            isStop = true;
                        }
                    }
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t1.interrupt();
        while (true) {
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis() - time < 2000) {
            }
            System.out.println(t1.isAlive());
        }

    }
}
