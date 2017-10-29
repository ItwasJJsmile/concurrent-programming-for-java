package org.lester.concurrence.chapterFour;

/**
 * Created by Dr.Lester on 2017/10/22.
 */
public class DaemonThread2 {

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Thread innerThread = new Thread(()->{
                try {
                    while (true) {
                        System.out.println("心跳检查ing...");
                        Thread.sleep(100_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"L");

            innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T线程运行结束...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //t.setDaemon(true);
        t.start();
    }
}
