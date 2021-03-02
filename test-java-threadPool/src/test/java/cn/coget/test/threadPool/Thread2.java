package cn.coget.test.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: sin
 * time: 2021/3/2 9:00 上午
 */
public class Thread2 {

    static final ReentrantLock lock = new ReentrantLock();
    static volatile boolean flag = true;

    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    lock.lock();
                    while (flag) {
                        System.err.println("for1");
                        LockSupport.park(this);
                        System.err.println("run执行完了!");
                    }
                    lock.unlock();
                }
            });

            thread1.start();
            threadList.add(thread1);
        }

        try {
            System.err.println("等待中断!");
            Thread.sleep(3000L);
            threadList.get(3).interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
