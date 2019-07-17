package com.clt.threadpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 15:56 2019/7/15
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
            pool.execute(() -> { // �ύ����߳����񣬲�ִ��
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "��ʼִ��");
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
                System.out.println(Thread.currentThread().getName() + "�߳̿�ʼִ��");
            });
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("ѭ������");
        pool.shutdown();
        System.out.println("�̳߳عر�");
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
                System.out.println(Thread.currentThread().getName() + "�߳̿�ʼִ��");
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
                System.out.println(Thread.currentThread().getName() + "�߳̿�ʼִ��");
            });
        }
        pool.shutdown();
    }

    public static void testScheduledThreadPool1() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 100; i++){
            pool.schedule(() -> System.out.println(Thread.currentThread().getName()+"һ���ʼִ��"),
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
            pool.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName()+"һ���ÿ������ִ��"),
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
