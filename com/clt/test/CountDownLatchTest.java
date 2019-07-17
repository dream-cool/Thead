package com.clt.test;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 10:29 2019/7/16
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
            System.out.println("��һ���߳̿�ʼִ��");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("��һ���߳�ִ�����");
            latch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("�ڶ����߳̿�ʼִ��");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("�ڶ����߳�ִ�����");
            latch.countDown();
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("����ִ��main�߳�");
    }
}
