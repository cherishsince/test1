package cn.coget.test.lock.交易打印;

/**
 * 交易打印
 *
 * author: sin
 * time: 2020/8/29 8:10 上午
 */
public class SynchronizedTests {

//    private Object monitor1 = new Object();
//    private Object monitor2 = new Object();

    public static void main(String[] args) {
        final SynchronizedTests tests = new SynchronizedTests();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    tests.start1();
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    tests.start2();
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void start1() {
        synchronized (this) {
            System.err.println("[1]执行了.");
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start2() {
        synchronized(this) {
            System.err.println("[2]执行了.");
            try {
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
