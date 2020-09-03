package cn.coget.test.lock.交易打印;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: sin
 * time: 2020/8/31 10:04 上午
 */
public class LockQueueTests {


    @Test
    public void queueTest() {
        final Lock lock = new ReentrantLock(true);

        final QueueFunc queueFunc = new QueueFunc() {
            public void task() {
                lock.lock();
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                queueFunc.task();
            }
        });

        t1.setName("t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                queueFunc.task();
            }
        });

        t2.setName("t2");

        t1.start();
        t2.start();
    }

    interface QueueFunc {
        void task();
    }
}
