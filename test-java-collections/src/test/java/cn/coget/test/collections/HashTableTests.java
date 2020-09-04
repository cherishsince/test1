package cn.coget.test.collections;

import org.junit.Test;

import java.util.Hashtable;

/**
 * author: sin
 * time: 2020/9/3 5:42 下午
 */
public class HashTableTests {

    @Test
    public void addTest() {
        Hashtable<String, Object> table = new Hashtable<>();
        table.put("1", 1);
    }
}
