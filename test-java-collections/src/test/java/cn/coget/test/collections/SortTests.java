package cn.coget.test.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * author: sin
 * time: 2020/9/5 12:13 下午
 */
public class SortTests {

    int size = 20;
    int[] array = new int[size];

    @Before
    public void setup() {
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(100);
        }
        printArray(array);
    }

    @Test
    public void 选择排序Test() {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int i1 = i; i1 < array.length; i1++) {
                if (array[i1] < array[min]) {
                    min = i1;
                }
            }
            int tmp = array[min]; // i1
            array[min] = array[i]; // i -->
            array[i] = tmp;
        }
        printArray(array);
    }

    @Test
    public void 冒泡排序Test() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] >= array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        printArray(array);
    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.err.print(i);
            System.err.print(",");
        }
        System.err.print("\n");
    }
}
