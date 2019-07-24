package com.clt.test;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:29 2019/7/16
 * CountDownLatch 和 CyclicBarrier 都能够实现线程之间的等待，只不过它们侧重点不
 * 同；CountDownLatch 一般用于某个线程 A 等待若干个其他线程执行完任务之后，它才
 * 执行；而 CyclicBarrier 一般用于一组线程互相等待至某个状态，然后这一组线程再同时
 * 执行；另外，CountDownLatch 是不能够重用的，而 CyclicBarrier 是可以重用的。
 * Semaphore 其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
            System.out.println("第一个线程开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第一个线程执行完成");
            latch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("第二个线程开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第二个线程执行完成");
            latch.countDown();
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("继续执行main线程");
    }
}
