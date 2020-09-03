package cn.coget.test.lock.交易打印;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock
 *
 * author: sin
 * time: 2020/8/29 8:08 上午
 */
public class ReentrantLockTests {

    Lock lock = new ReentrantLock();

    @Test
    public void lockTest() {
        lock.lock();
    }


    @Test
    public void lock2Test() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reentrantLockTest() {
        System.err.println(new Random().nextInt(1000));
        lock.unlock();
    }
}
