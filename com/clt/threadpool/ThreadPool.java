package com.clt.threadpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 15:56 2019/7/15
 */
public class ThreadPool {
    public static void main(String[] args) {
        testFixedThreadPool1();
    }

    public static void testFixedThreadPool1() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future> ls = new ArrayList<>(10);
        for (int i = 0; i < 100; i++) {
            Future future = pool.submit(() -> {
                HashMap<String, Integer> map = new HashMap<>(10);
                map.put(Thread.currentThread().getName(), (int) (Math.random() * 100));
                return map;
            });
            ls.add(future);
        }
        pool.shutdown();
        for (Future f : ls) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testFixedThreadPool2() {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        while (true) {
            pool.execute(() -> { // 提交多个线程任务，并执行
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "开始执行");
            });
        }
    }

    public static void testFixedThreadPool3() {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程开始执行");
            });
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("循环结束");
        pool.shutdown();
        System.out.println("线程池关闭");
    }

    public static void testCachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程开始执行");
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    public static void testSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程开始执行");
            });
        }
        pool.shutdown();
    }

    public static void testScheduledThreadPool1() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 100; i++){
            pool.schedule(() -> System.out.println(Thread.currentThread().getName()+"一秒后开始执行"),
                    1, TimeUnit.SECONDS);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    public static void testScheduledThreadPool2() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 100; i++){
            pool.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName()+"一秒后每隔三秒执行"),
                    1,3, TimeUnit.SECONDS);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

}
