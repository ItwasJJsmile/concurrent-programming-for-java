package org.lester.concurrence.chapterTwo;

/**
 * Created by Godql on 2017/10/1.
 * 计算器：计算税务
 */
public class TaxCalculator {

    // 工资
    private final double salary;

    // 奖金
    private final double bonus;

    // 计算策略
    private final ICalculativeStrategy iCalculativeStrategy;

    public TaxCalculator(double salary, double bonus, ICalculativeStrategy iCalculativeStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.iCalculativeStrategy = iCalculativeStrategy;
    }

    // 算法
    protected double calcTax() {
       return iCalculativeStrategy.calculate(salary, bonus);
    }

    // 计算
    public double calculate() {
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

}
