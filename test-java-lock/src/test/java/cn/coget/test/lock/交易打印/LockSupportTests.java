package cn.coget.test.lock.交易打印;

import java.util.concurrent.locks.LockSupport;

/**
 * author: sin
 * time: 2020/8/29 12:04 下午
 */
public class LockSupportTests {

    public void test() {
        LockSupport.unpark(Thread.currentThread());
    }
}
