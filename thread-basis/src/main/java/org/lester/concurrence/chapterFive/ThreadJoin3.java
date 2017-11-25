package org.lester.concurrence.chapterFive;

/**
 * Created by Dr.Lester on 2017/11/25.
 */
public class ThreadJoin3 {

    public static void main(String[] args) {
        // 开始时间
        long startTimestamp = System.currentTimeMillis();

        Thread t1 = new Thread(new CaptureRunnable("第一台机器", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("第二台机器", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("第三台机器", 15000L));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 结束时间
        long endTimestamp = System.currentTimeMillis();
        System.out.printf("保存数据开始时间戳:%s, 结束时间戳:%s\n", startTimestamp, endTimestamp);
    }
}

class CaptureRunnable implements Runnable {

    // 采集的机器
    private String machineNmae;

    // 采集时间
    private long spendTime;

    public CaptureRunnable(String machineNmae, long spendTime) {
        this.machineNmae = machineNmae;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            // 模拟采集
            Thread.sleep(spendTime);
            System.out.printf(machineNmae + "完成数据捕获的时间戳：%s 并成功完成.\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 采集结果
    public String getResult() {
        return machineNmae+ "采集完成.";
    }
}