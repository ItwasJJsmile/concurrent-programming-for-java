package org.lester.concurrence.chapterFour;

import java.util.Optional;

/**
 * Created by Dr.Lester on 2017/11/12.
 */
public class ThreadSimpleAPI2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        }, "t1");
        // 最高优先级 10
        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        }, "t2");
        // 标准优先级 5
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Optional.of(Thread.currentThread().getName() + "-index" + i).ifPresent(System.out::println);
            }
        }, "t3");
        // 最低优先级 1
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
