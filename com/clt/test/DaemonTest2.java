package com.clt.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author   £∫clt.
 * @ Date     £∫Created in 14:51 2019/7/17
 */
public class DaemonTest2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor(new ThreadFactoryTest());
        pool.execute(()->{
            System.out.println(Thread.currentThread().getName()+Thread.currentThread().isDaemon());
            Thread[] threads = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads[i] = new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+" ÿª§œﬂ≥Ã£∫"+Thread.currentThread().isDaemon());
                });
                threads[i].start();
            }
        });
        pool.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
