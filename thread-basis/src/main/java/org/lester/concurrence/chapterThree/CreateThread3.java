package org.lester.concurrence.chapterThree;

/**
 * Created by Dr.Lester on 2017/10/2.
 */
public class CreateThread3 {

    // 计数器
    private static int counter = 0;

    public static void main(String[] args) {
        try {
            add(0);
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(counter);
        }
    }

    private static void add(int i) {
        ++counter;
        add(i + 1);
    }
}
