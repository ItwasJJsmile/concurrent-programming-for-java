package org.lester.concurrence.chapterFive;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by Dr.Lester on 2017/11/25.
 */
public class ThreadJoin2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1--运行中");
                Thread.sleep(10_000);
                System.out.println("t1--任务完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        try {
            // 等待100毫秒10纳秒
            t1.join(100,10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional.of("所有的任务都完成了").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i->System.out.println(Thread.currentThread().getName() + "->" + i));

    }
}
