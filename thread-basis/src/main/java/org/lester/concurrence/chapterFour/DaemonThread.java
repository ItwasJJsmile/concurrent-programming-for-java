package org.lester.concurrence.chapterFour;

/**
 * Created by Dr.Lester on 2017/10/20.
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" running");
                    Thread.sleep(20000);
                    System.out.println(Thread.currentThread().getName()+" done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; // new

        // 设置为守护线程
        t.setDaemon(true);

        // runnable -> running | - >dead | -> blocked
        t.start();
        t.getName();

        Thread.sleep(10_000);  // JDK1.7新特性
        System.out.println(Thread.currentThread().getName());
    }


/**
 * A(client)<--------------------------->B(server)
 *  ->daemonThread(health check)
  */
}
