package cn.coget.test.lock.交易打印;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: sin
 * time: 2020/8/31 10:04 上午
 */
public class UnLockTests {

    @Test
    public void unLockTest() {
        Lock lock = new ReentrantLock();
        lock.unlock();
    }
}
