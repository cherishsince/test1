package cn.coget.test.jdk7;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * - 加载因子 0.75
 * - 默认为 16大小
 * - 最大值 1 << 30(1073741824 10亿多)
 *
 * author: sin
 * time: 2020/9/4 7:33 上午
 */
public class Java7ConcurrentHashMapTests {

    @Test
    public void initTest() {
        ConcurrentHashMap<String, Integer> data
                = new ConcurrentHashMap<>(16, 0.75F, 16);
        data.put("key1", 1);
    }

    @Test
    public void putTest() {
        ConcurrentHashMap<String, Integer> data
                = new ConcurrentHashMap<>(10, 0.75F, 10);
        data.put("key1", 1);
    }

    @Test
    public void maxValueTest() {
        // 1073741824
        System.err.println(1 << 30);
        // 1073741824
        System.err.println(2 << 29);
        System.err.println(0 << 0);
    }
}
