package cn.coget.test.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LinkedHashMap tests
 *
 * author: Sin
 * time: 2020/7/8 9:26
 */
public class LinkedHashMapTests {

    private LinkedHashMap<String, Integer> linkedHashMap = null;

    @Before
    public void setup() {
        System.err.println("setup.");
    }

    @Test
    public void putTest() {
        linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key1", 11);
    }
}
