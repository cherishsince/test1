package cn.coget.test.collections;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * author: sin
 * time: 2020/9/3 5:45 下午
 */
public class ConcurrentHashMapTests {

    @Test
    public void putTest() {
        ConcurrentHashMap<String, Integer> data = new ConcurrentHashMap<>();
        data.put("1", 1);
    }
}
