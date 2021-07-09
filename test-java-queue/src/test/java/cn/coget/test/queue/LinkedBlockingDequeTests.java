package cn.coget.test.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * linked queue
 *
 * author: sin
 * time: 2020/9/16 12:56 下午
 */
public class LinkedBlockingDequeTests {

    private static Logger logger = LoggerFactory.getLogger(LinkedBlockingDequeTests.class);

    public static void main(String[] args) {
        int maxCount = 10;
        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(maxCount);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int i12 = 0; i12 < 1; i12++) {
                    try {
                        queue.put(count.getAndIncrement());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println("生成一个产品!");
                }
            }).start();
        }

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 1; i1++) {
                    try {
                        System.err.println("消费一个产品! " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        logger.debug("执行完了!");
        String a = "";
    }
}
