package com.clt.threadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 14:34 2019/7/26
 */
public class ThreadLocalTest1 {
    public static Integer getValue() {
        return value.get();
    }

    public static void setValue(Integer v) {
        value.set(v);
    }

    private static ThreadLocal<Integer> value = new ThreadLocal<>();
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        ThreadTest run = new ThreadTest(latch);
        Thread thread1 = new Thread(run,"线程一");
        Thread thread2 = new Thread(run,"线程二");
        thread1.start();
        thread2.start();
        value.set(50);
        System.out.println(Thread.currentThread().getName()+"----"+ThreadLocalTest1.getValue());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadTest implements Runnable{
    private CountDownLatch latch;

    public ThreadTest(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        if ("线程一".equals(Thread.currentThread().getName())){
            ThreadLocalTest1.setValue(10);
        }
        if ("线程二".equals(Thread.currentThread().getName())){
            ThreadLocalTest1.setValue(20);
        }
        System.out.println(Thread.currentThread().getName()+"----"+ThreadLocalTest1.getValue());
        latch.countDown();
    }
}
