package com.clt.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 13:37 2019/7/17
 */
public class DaemonTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Thread mainThread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"���߳̿�ʼִ��");
        });

        mainThread.start();
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"�ػ��߳�ִ��");
        });

        thread.setDaemon(true);
        thread.start();


//        pool.execute(()->{
//        });
//        pool.shutdown();

    }
}
