package com.clt.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 13:29 2019/7/17
 */
public class CountDownLatchTest1 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(100);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"：辅助线程开始执行,main线程等待");
                    latch.countDown();
            });
        }
        pool.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程继续执行");
    }

}
