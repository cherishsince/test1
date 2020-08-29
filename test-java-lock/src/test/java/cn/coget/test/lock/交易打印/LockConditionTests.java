package cn.coget.test.lock.交易打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition 交替打印
 *
 * author: sin
 * time: 2020/8/29 7:56 上午
 */
public class LockConditionTests {

    private Lock lock = new ReentrantLock();
    // 创建两个 condition 条件，用户 1 和 2 的配合，交叉打印
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        final LockConditionTests tests = new LockConditionTests();
        tests.startCondition1();
        tests.startCondition2();
    }

    public void startCondition1() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // 获取锁
                    lock.lock();
                    try {
                        System.err.println("condition1 生产了.");
                        condition2.signal();
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 解锁
                        lock.unlock();
                    }
                }
            }
        }).start();
    }

    public void startCondition2() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    // 获取锁
                    lock.lock();
                    try {
                        System.err.println("condition2 消费了.");
                        condition1.signal();
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 解锁
                        lock.unlock();
                    }
                }
            }
        }).start();
    }
}
