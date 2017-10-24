package com.ran.learn.thread.lession01;

/**
 * Created by zhangran on 2017/7/8.
 */
public class Bank {

    public static void main(String[] args) {

        String s= "(/:pig|/:rose)";
        String words = "爱哭的舒服就好阿拉山口地方就/:pig,asjkdfa爱上的看/:rose";
        words.replaceAll(s,"[表情]");
        System.out.print(words);
    }
}
