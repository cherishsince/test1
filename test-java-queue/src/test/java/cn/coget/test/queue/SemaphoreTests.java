package cn.coget.test.queue;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 *
 * author: sin
 * time: 2021/3/2 3:03 下午
 */
public class SemaphoreTests {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("执行了! " + finalI);
                try {
                    Thread.sleep(new Random().nextInt(3000));
//                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            }).start();
        }
    }
}
