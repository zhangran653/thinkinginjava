package com.ran.learn.season3;

import java.util.LinkedList;

/**
 * Created by zhangran on 2017/11/20.
 */
public class ReqeustQueue {
    private LinkedList<Request> list = new LinkedList<>();

    public Request getRequest() {
        synchronized (list) {
            while (list.size() == 0) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            return list.removeFirst();
        }
    }

    public void putRequest(Request request) {
        synchronized (list) {
            list.addLast(request);
            list.notifyAll();
        }
    }

}
