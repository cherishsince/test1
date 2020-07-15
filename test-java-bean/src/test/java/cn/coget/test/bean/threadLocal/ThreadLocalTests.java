package cn.coget.test.bean.threadLocal;

import org.junit.Before;
import org.junit.Test;

/**
 * author: Sin
 * time: 2020/7/15 17:52
 */
public class ThreadLocalTests {

    /**
     * ThreadLocal 使用 WeakReference(弱引用)，由于 gc 线程执行优先级比较低，所以回收不会那么快
     */
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Before
    public void setup() {
        threadLocal.set("xy");
    }

    @Test
    public void getTest() {
        System.err.println(threadLocal.get());
        byte[] a = new byte[1];
        String ss = new String(a);
        System.err.println(ss);
    }
}
