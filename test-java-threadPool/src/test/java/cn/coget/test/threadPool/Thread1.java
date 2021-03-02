package cn.coget.test.threadPool;

import java.util.concurrent.locks.LockSupport;

/**
 * author: sin
 * time: 2021/3/2 9:00 上午
 */
public class Thread1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
               for (;;) {
                   System.err.println("for1");
                   LockSupport.park();
                   System.err.println("run执行完了!");
               }
            }
        });

        thread1.start();

        try {
            System.err.println("等待中断!");
            Thread.sleep(3000L);
            thread1.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
