package cn.coget.test.lock.死锁;

/**
 * 死锁
 *
 * - 互斥条件
 * - 请求与保持条件
 * - 不剥夺条件
 * - 循环等待条件
 *
 * author: sin
 * time: 2020/8/29 8:12 上午
 */
public class DeadlockSyncTests {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    public static void main(String[] args) {
        final DeadlockSyncTests tests = new DeadlockSyncTests();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    tests.monitor1Start();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    tests.monitor2Start();
                }
            }
        }).start();
    }

    public void monitor1Start() {
        synchronized (monitor1) {
            System.err.println("[1]拿到monitor1了.");
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor2) {
                System.err.println("[1]拿到monitor2了.");
                try {
                    Thread.sleep(90L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void monitor2Start() {
        synchronized (monitor2) {
            System.err.println("[2]拿到monitor2了.");
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor1) {
                System.err.println("[2]拿到monitor1了.");
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
