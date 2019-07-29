package com.clt.atom;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 16:31 2019/7/25
 */
public class AtomTest {
    private static int n = 0;
    private static AtomicInteger num = new AtomicInteger(0);

    @Test
    public void testInteger1() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    num.incrementAndGet();
                }
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

    @Test
    public void testInteger2() {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    n++;
                }
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }

    @Test
    public void testInteger3() {
        AtomicInteger integer = new AtomicInteger();
        System.out.println(integer.compareAndSet(0, 2));
        System.out.println(integer.incrementAndGet());
        System.out.println("---------------1");
        System.out.println(integer.addAndGet(10));
        System.out.println("---------------2");
        System.out.println(integer.getAndAdd(10));
        System.out.println("---------------3");
        System.out.println(integer.doubleValue());
        System.out.println("---------------4");
        System.out.println(integer.getAndSet(-10));
        System.out.println("---------------5");
        System.out.println(integer.weakCompareAndSet(-10, 1));
        integer.lazySet(11);
        System.out.println("---------------6");
        System.out.println(integer.getAndUpdate((p) -> 3));
        System.out.println(integer);
        System.out.println("---------------7");
        System.out.println(integer.getAndAccumulate(2, ((left, right) -> left * right)));
        System.out.println(integer);
        System.out.println("---------------8");
    }
}
