package cn.coget.test.collections.collections;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

/**
 * 集合测试
 *
 * author: Sin
 * time: 2020/7/9 11:42
 */
public class CollectionsTests {

    @Test
    public void synchronizedMapTest() {
        HashMap<String, Object> hashMap = new HashMap(10);
        Collections.synchronizedMap(hashMap);
    }
}
