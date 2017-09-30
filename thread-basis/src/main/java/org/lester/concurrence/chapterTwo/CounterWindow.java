package org.lester.concurrence.chapterTwo;

/**
 * Created by Dr.Lester on 2017/9/27.
 * 柜台窗口
 * Versions 1.0
 */
public class CounterWindow  extends Thread {

    // 柜台名称
    private final String name;

    // 号数初始化
    private static int index = 1;

    // 号数最大值
    private static final int MAX = 50;

    public CounterWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台:" + name + "当前的号码是:" + (index++));
        }
    }
}
