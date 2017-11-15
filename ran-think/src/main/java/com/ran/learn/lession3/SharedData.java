package com.ran.learn.lession3;

/**
 * Created by zhangran on 2017/11/5.
 */
public class SharedData {
    private char[] data = new char[10];

    public SharedData(char c) {
        for (int i = 0; i < data.length; i++) {
            data[i] = c;
        }
    }

    public String readData() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            s.append(data[i]);
        }
        return s.toString();
    }

    public void writeData(char c) {
        System.out.println(Thread.currentThread().getName() + " write date char[" + c + "]");
        for (int i = 0; i < data.length; i++) {
            data[i] = c;
        }
    }


}
