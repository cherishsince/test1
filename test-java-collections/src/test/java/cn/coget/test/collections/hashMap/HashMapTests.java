package cn.coget.test.collections.hashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * hash map 测试
 *
 * author: sin
 * time: 2020/7/7 10:01 下午
 */
public class HashMapTests {

    HashMap<String, Integer> hashMap;

    @Before
    public void setup() {
        hashMap = new HashMap<String, Integer>();
        System.err.println("setup");
    }

    @Test
    public void putItemTest() {
        hashMap.put("key1", 10);
        Assert.assertTrue("hash map size request 1!", hashMap.size() == 1);
    }

    @Test
    public void repeatKeyTest() {
        hashMap.put("key1", 10);
        hashMap.put("key1", 10);
        Assert.assertTrue("hash map size request 1!", hashMap.size() == 1);
    }

    @Test
    public void nullKeyTest() {
        hashMap.put("key1", 10);
        hashMap.put(null, 10);
        Assert.assertTrue("hash map size request 1!", hashMap.size() == 1);
    }
}
