package cn.coget.test.lock.交易打印;

import java.util.Random;

/**
 * 交易打印
 *
 * author: sin
 * time: 2020/8/29 8:10 上午
 */
public class Synchronized2Tests {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    public static void main(String[] args) {
        final Synchronized2Tests tests = new Synchronized2Tests();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    tests.start1();
                    try {
                        Thread.sleep(new Random().nextInt(500));
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
                        Thread.sleep(new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void start1() {
        System.err.println("[1]执行了.");
        synchronized (monitor2) {
            monitor2.notifyAll();
        }
        synchronized (monitor1) {
            try {
                monitor1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start2() {
        System.err.println("[2]执行了.");
        synchronized (monitor1) {
            monitor1.notifyAll();
        }
        synchronized(monitor2) {
            try {
                monitor2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
