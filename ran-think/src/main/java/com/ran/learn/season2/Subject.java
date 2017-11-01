package com.ran.learn.season2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangran on 2017/11/2.
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public void setState(int state) {
        if (this.state == state) {
            return;
        }
        this.state = state;
        notifyAllObservers();

    }

    public int getState() {
        return state;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        observers.stream().forEach(o -> o.update());
    }

}
