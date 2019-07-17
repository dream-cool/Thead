package com.clt.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 16:53 2019/7/15
 */
public class CallableTest implements Callable<Integer> {

    public static void main(String[] args) {
        CallableTest callable = new CallableTest();
        FutureTask<Integer> future1 = new FutureTask<>(callable);
        new Thread(future1, "线程一").start();
        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        FutureTask future2 = new FutureTask<>(new CallableTest());
        new Thread(future2, "线程二").start();
        try {
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() {
        System.out.println(Thread.currentThread().getName() + "开始执行");
        return (int) (Math.random() * 100);
    }
}
