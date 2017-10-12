package org.lester.concurrence.chapterTwo;

/**
 * Created by Dr.Lester on 2017/10/1.
 * 计算策略
 */
@FunctionalInterface
public interface ICalculativeStrategy {

    double calculate(double salary, double bonus);
}
