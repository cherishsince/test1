package cn.coget.test.collections;

import org.junit.Test;

import java.util.HashSet;

/**
 * author: sin
 * time: 2020/9/3 4:44 下午
 */
public class BashSetTests {

    @Test
    public void putTest() {
        // HashSet 用的就是 HashMap，只用到了 hash map 的key
        HashSet<Integer> sets = new HashSet<>();
        sets.add(1);
    }
}
