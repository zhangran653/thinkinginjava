package com.ran.learn.concurrency.chapter02;

public class CalculatorMain {

    public static void main(String[] args) {
        TaxCalculator t1 = new TaxCalculator(1000d, 2000d);

        TaxStratage t = new SimpleTaxStratege();
        t1.setS(t);

        System.out.println(t1.calculate());
    }
}
