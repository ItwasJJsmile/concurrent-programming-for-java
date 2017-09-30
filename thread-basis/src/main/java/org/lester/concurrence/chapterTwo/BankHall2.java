package org.lester.concurrence.chapterTwo;

/**
 * Created by Godql on 2017/10/1.
 * 银行大厅
 * Versions 1.2
 */
public class BankHall2 {

    // 号数最大值
    private final static int MAX = 50;

    public static void main(String[] args) {
//        final CounterWindowRunnable counterWindow = new CounterWindowRunnable();

        final Runnable ticketWindow = () -> {
            // 号数初始化
            int index = 1;
            while (index <= MAX) {
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();

    }
}
