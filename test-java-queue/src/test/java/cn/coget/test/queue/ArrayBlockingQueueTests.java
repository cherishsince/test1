package cn.coget.test.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * author: sin
 * time: 2020/8/29 7:51 上午
 */
public class ArrayBlockingQueueTests {

    private ArrayBlockingQueue queue;

    @Before
    public void setup() {
        queue = new ArrayBlockingQueue(2);
    }

    @Test
    public void queueTest() {
        queue.add(1);
        queue.add(1);
        queue.add(1);
    }
}
