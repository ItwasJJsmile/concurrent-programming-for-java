package org.lester.concurrence.chapterTwo;

/**
 * Created by Dr.Lester on 2017/10/1.
 * 柜台窗口
 * Versions 1.2
 */
public class CounterWindowRunnable implements Runnable {

    // 号数初始化
    private static int index = 1;

    // 号数最大值
    private static final int MAX = 50;

    @Override
    public void run() {
       while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            try {
                // 有线程安全问题让线程暂时先睡一会
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
