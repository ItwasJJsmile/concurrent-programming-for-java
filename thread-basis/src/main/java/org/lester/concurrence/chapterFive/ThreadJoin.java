package org.lester.concurrence.chapterFive;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by Dr.Lester on 2017/11/25.
 */
public class ThreadJoin {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            IntStream.range(1, 1000)
                    .forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1, 1000)
                    .forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional.of("所有的任务都完成了").ifPresent(System.out::println);
        // 主线程也做一遍
        IntStream.range(1, 1000)
                .forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}
