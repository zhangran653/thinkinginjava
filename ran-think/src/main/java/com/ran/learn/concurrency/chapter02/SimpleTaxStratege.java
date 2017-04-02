package com.ran.learn.concurrency.chapter02;

public class SimpleTaxStratege implements TaxStratage {

    private static final double SALARY_RATE = 0.1d;

    private static final double BONUS_RATE = 0.2d;

    @Override
    public double calc(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }

}
