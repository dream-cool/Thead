package com.clt.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @ Author   £∫clt.
 * @ Date     £∫Created in 14:19 2019/7/17
 */
public class DaemonTest1 {
    public static void main(String[] args) {
        ExecutorService  pool = Executors.newFixedThreadPool(5,new ThreadFactoryTest());
        for (int i = 0; i < 10; i++) {
                pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"---"
                        +Thread.currentThread().getPriority()+"---"+Thread.currentThread().getId()+
                        "---"+Thread.currentThread().isDaemon());
            });
        }
        pool.shutdown();
    }
}
class ThreadFactoryTest implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.setName("testœﬂ≥Ã");
        thread.setPriority(10);
        return thread;
    }
}
