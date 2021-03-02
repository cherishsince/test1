package cn.coget.test.gc.stw;

/**
 * stop the word
 * <p>
 * author: sin
 * time: 2021/2/23 10:47 上午
 */
public class StopTheWord {

    // -Xmx15m -Xms15m -XX:+PrintGC -XX:+DoEscapeAnalysis -XX:+EliminateAllocations
    // -Xmx15m -Xms15m -XX:+PrintGC -XX:-DoEscapeAnalysis -XX:-EliminateAllocations

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        System.out.println("cost = " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void alloc() {
//        User user = new User();
//        user.setName("zhuge");
        new Object();
    }
}
