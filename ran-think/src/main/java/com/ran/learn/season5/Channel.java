package com.ran.learn.season5;

import java.util.Arrays;

/**
 * @author
 * @create 2017-11-26 下午10:32
 **/
public class Channel {
    private final int MAX_SIZE = 100;
    private final Request[] requests;

    private int head;
    private int tail;
    private int count;

    private final Worker[] workers;


    public Channel(int workers) {
        this.requests = new Request[MAX_SIZE];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.workers = new Worker[workers];
        init();
    }

    private void init() {
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        Arrays.asList(workers).forEach(Worker::start);
    }

    public synchronized void put(Request request) {
        while (count >= requests.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requests[tail] = request;
        tail = (tail + 1) % requests.length;
        count++;
        this.notifyAll();
    }

    public synchronized Request take() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requests[head];
        head = (head + 1) % requests.length;
        count--;
        this.notifyAll();
        return request;

    }

}
