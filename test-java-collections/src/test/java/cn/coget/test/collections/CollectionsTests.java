package cn.coget.test.collections;

import java.util.Collections;

/**
 * author: sin
 * time: 2020/9/3 4:57 下午
 */
public class CollectionsTests {

    public void syncTest() {
        Collections.synchronizedMap(null);
        Collections.synchronizedSet(null);
        Collections.synchronizedList(null);
        Collections.synchronizedCollection(null);
    }
}
