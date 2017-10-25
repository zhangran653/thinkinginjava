package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/25.
 */
public class ThreadClose2 {
    private static class Worker extends Thread {
        private volatile boolean isShouDown = false;

        @Override
        public void run() {
            while (true) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    break;
//                }
                if(Thread.interrupted())
                    break;
            }
        }

        public static void main(String[] args) {
            Worker w = new Worker();
            w.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            w.interrupt();

        }


    }

}
