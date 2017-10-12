package org.lester.concurrence.chapterThree;

import java.util.Arrays;

/**
 * Created by Dr.Lester on 2017/10/2.
 */
public class CreateThread2 {

    public static void main(String[] args) {
        Thread t = new Thread("T"){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        //System.out.println("T线程的ThreadGroup：" + t.getThreadGroup());
        //System.out.println("main线程的ThreadGroup：" + Thread.currentThread().getName());
        //System.out.println("main线程爹的ThreadGroup：" + Thread.currentThread().getThreadGroup().getName());

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        //System.out.println(threadGroup.activeCount());

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
        /*for (Thread temp : threads) {
            System.out.println(temp);
        }*/
    }
}
