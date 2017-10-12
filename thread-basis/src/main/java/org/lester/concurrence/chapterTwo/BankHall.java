package org.lester.concurrence.chapterTwo;

/**
 * Created by Dr.Lester on 2017/10/1.
 * 银行大厅
 */
public class BankHall {

    public static void main(String[] args) {

        CounterWindow c1 = new CounterWindow("一号柜台");
        c1.start();

        CounterWindow c2 = new CounterWindow("二号柜台");
        c2.start();

        CounterWindow c3 = new CounterWindow("三号柜台");
        c3.start();
    }
}
