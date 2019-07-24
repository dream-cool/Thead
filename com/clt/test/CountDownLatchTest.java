package com.clt.test;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 10:29 2019/7/16
 * CountDownLatch �� CyclicBarrier ���ܹ�ʵ���߳�֮��ĵȴ���ֻ�������ǲ��ص㲻
 * ͬ��CountDownLatch һ������ĳ���߳� A �ȴ����ɸ������߳�ִ��������֮������
 * ִ�У��� CyclicBarrier һ������һ���̻߳���ȴ���ĳ��״̬��Ȼ����һ���߳���ͬʱ
 * ִ�У����⣬CountDownLatch �ǲ��ܹ����õģ��� CyclicBarrier �ǿ������õġ�
 * Semaphore ��ʵ�����е����ƣ���һ�����ڿ��ƶ�ĳ����Դ�ķ���Ȩ�ޡ�
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
