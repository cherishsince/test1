package cn.coget.test.collections.hashMap;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap tests
 *
 * author: Sin
 * time: 2020/7/9 9:10
 */
public class ConcurrentHashMapTests {

    private ConcurrentHashMap<String, Integer> concurrentHashMap;

    @Before
    public void setup() {
        concurrentHashMap = new ConcurrentHashMap<String, Integer>();
    }

    @Test
    public void putTest() {
        concurrentHashMap.put("key1", 1);
    }
}
