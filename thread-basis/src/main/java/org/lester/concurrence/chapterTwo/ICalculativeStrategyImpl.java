package org.lester.concurrence.chapterTwo;

/**
 * Created by Dr.Lester on 2017/10/1.
 */
public class ICalculativeStrategyImpl implements ICalculativeStrategy {

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }

}
