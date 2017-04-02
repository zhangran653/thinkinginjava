package com.ran.learn.concurrency;

public class TryConcurrency {

    public static void main(String[] args) {
        
        Thread t1 = new Thread(){
            @Override
            public void run(){
                readFromDatabase();
            }
        };
        t1.start();
        writeToFile();
        
        
//        readFromDatabase();
//        writeToFile();
    }

    private static void readFromDatabase() {
        try {
            System.out.println("read from db");
            Thread.sleep(1000 * 5);
            System.out.println("read from db and handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("handle success.");
    }

    private static void writeToFile() {
        try {
            System.out.println("write to file");
            Thread.sleep(1000 * 5);
            System.out.println("write file and handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("handle success.");
    }
}
