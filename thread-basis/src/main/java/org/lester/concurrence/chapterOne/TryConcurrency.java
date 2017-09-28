package org.lester.concurrence.chapterOne;

/**
 * Created by Dr.Lester on 2017/9/28.
 * 企图并发
 */
public class TryConcurrency {

    public static void main(String[] args) {

        new Thread("READ-Thread"){
            @Override
            public void run() {
                readFromDataBase();
            }
        }.start();

        new Thread("WRITE-Thread"){
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    private static void readFromDataBase() {
        // 从数据库读取数据并处理.
        try {
            println("开始读取数据库中的数据。");
            Thread.sleep(1000 * 20L);
            println("读取数据并开始处理。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("数据处理完成并成功完成。");
    }

    private static void writeDataToFile() {
        // 将数据写入文件并处理
        try {
            println("开始将数据写入文件。");
            Thread.sleep(2000 * 20L);
            println("写数据并开始处理。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("数据处理完成并成功完成。");
    }


    private static void println(String message) {
        System.out.println(message);

    }



}
