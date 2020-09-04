package cn.coget.test.jdk7;

import org.junit.Test;

import java.util.Hashtable;

/**
 * author: sin
 * time: 2020/9/4 1:20 下午
 */
public class Java7HashTableTests {

    @Test
    public void putTest() {
        Hashtable<String, Integer> tables = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            tables.put("key" + i, 1);
        }
    }
}
