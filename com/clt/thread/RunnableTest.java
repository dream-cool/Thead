package com.clt.thread;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 16:50 2019/7/15
 */
public class RunnableTest implements  Runnable{

    public static void main(String[] args) {
        new Thread(new RunnableTest(),"sb").start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"线程执行结束");
    }
}
