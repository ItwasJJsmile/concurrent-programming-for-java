package org.lester.concurrence.chapterThree;

/**
 * Created by Dr.Lester on 2017/10/2.
 */
public class CreateThread4 {

    // 计数器
    private static int counter = 1;

    public static void main(String[] args) {

        Thread t = new Thread(null,new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    e.printStackTrace();
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                ++counter;
                add(i + 1);
            }
        },"myThread", 1 << 24);
        t.start();
    }
}
