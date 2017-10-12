package org.lester.concurrence.chapterThree;

/**
 * Created by Dr.Lester on 2017/10/2.
 * 创建线程
 */
public class CreateThread {

    public static void main(String[] args) {
        Thread t1 = new Thread();

        Thread t2 = new Thread() {
            @Override
            public void run () {
                System.out.println("我是run()方法");
            }
        };

        Thread t3 = new Thread("ThreadName");

        Thread t4 = new Thread(()-> {
            System.out.println("Runnable...");
        });

        Thread t5 = new Thread(()-> {
            System.out.println("Runnable..." + Thread.currentThread().getName());
        }, "RunnableThread");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        System.out.println(t1.getName());
        System.out.println(t1.getName());
        System.out.println(t3.getName());
        System.out.println(t4.getName());
    }
}
