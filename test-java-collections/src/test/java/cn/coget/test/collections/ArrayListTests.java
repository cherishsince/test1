package cn.coget.test.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * author: sin
 * time: 2020/9/3 4:04 下午
 */
public class ArrayListTests {

    @Test
    public void addTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

    }
}
