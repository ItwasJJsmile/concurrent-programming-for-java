package org.lester.concurrence.chapterTwo;

/**
 * Created by Dr.Lester on 2017/10/1.
 * 计算
 */
public class TaxCalculatorMain {

    public static void main(String[] args) {

        TaxCalculator calculator = new TaxCalculator(10000d, 2000d, (s, b) -> s * 0.1 + b * 0.15);
        System.out.println(calculator.calculate());

    }
}
