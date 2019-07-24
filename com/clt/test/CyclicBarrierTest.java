package com.clt.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;


/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:33 2019/7/17
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        for (int i = 0; i < 5; i++) {
            new CyclicBarrierThread(barrier).start();
        }
    }
}

class CyclicBarrierThread extends Thread{
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"线程执行完成");
            TimeUnit.SECONDS.sleep(1);
            cyclicBarrier.await();
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}