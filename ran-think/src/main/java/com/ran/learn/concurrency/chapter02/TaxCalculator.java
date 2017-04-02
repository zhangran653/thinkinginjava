package com.ran.learn.concurrency.chapter02;

public class TaxCalculator {

    private final double salary;

    private final double bonus;

    private TaxStratage s;

    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public TaxStratage getS() {
        return s;
    }

    public void setS(TaxStratage s) {
        this.s = s;
    }

    protected double calcTax() {
        return s.calc(getSalary(), getBonus());
    }

    public double calculate() {
        return calcTax();
    }
}
