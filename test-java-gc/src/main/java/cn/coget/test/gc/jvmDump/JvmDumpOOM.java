package cn.coget.test.gc.jvmDump;

import java.util.ArrayList;
import java.util.List;

/**
 * author: sin
 * time: 2021/2/24 6:14 下午
 */
public class JvmDumpOOM {

    public static List<Object> list = new ArrayList<>();
    // JVM设置    
    // -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/sin/jvm.dump
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new Object());
            new Object();
        }
    }
}
