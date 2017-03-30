package com.ran.think.concurrency;

/**
 * 
 * @author zr
 *
 */
public class BasicThreads {

    /**
     * 将Runnable转换为工作任务的传统方式是将它交给一个Thread构造器。 start()方法产生的对LiffOff.run()方法的调用。
     * 
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Wating for LiftOff");
    }
}
