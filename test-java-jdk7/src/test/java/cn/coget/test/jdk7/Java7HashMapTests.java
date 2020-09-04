package cn.coget.test.jdk7;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * author: sin
 * time: 2020/9/4 7:51 上午
 */
public class Java7HashMapTests {

    @Test
    public void iteratorTest() {
        HashMap<String, Integer> data = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            data.put("key" + i, i);
        }

        Iterator<Map.Entry<String,Integer>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entry = iterator.next();
            System.err.println(entry.getKey() + " - " + entry.getValue());
            iterator.remove();
        }
    }

    @Test
    public void resizeTest() {
        int size = 9999999;
        Integer.highestOneBit(size);
    }

    @Test
    public void inflateTest() {
        // inflate test
        HashMap<String, Integer> data = new HashMap<>(10, 0.75F);
        for (int i = 0; i < 10000; i++) {
            data.put("key" + i, i);
        }

        System.err.println(0);
    }

    @Test
    public void sizeAndModCountTest() {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("key1", 1);
        System.err.println(data.size());
        System.err.println(data.size());
    }
}
