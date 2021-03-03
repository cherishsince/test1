package cn.coget.test.lock.cas;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: sin
 * time: 2021/3/2 6:40 下午
 */
public class AtomicIntegerTests {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        integer.incrementAndGet();

    }
}
