package com.clt.test;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 10:29 2019/7/16
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
