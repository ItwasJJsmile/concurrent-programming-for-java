package org.lester.concurrence.chapterTwo;

/**
 * Created by Godql on 2017/10/1.
 */
public class CalculativeStrategyImpl implements ICalculativeStrategy {

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }

}
