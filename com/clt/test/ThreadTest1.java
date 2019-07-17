package com.clt.test;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 15:26 2019/7/17
 */
public class ThreadTest1 extends Thread{

    public ThreadTest1() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new ThreadTest1();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
