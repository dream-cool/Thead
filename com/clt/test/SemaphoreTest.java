package com.clt.test;

import java.util.concurrent.Semaphore;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 20:55 2019/7/17
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new SemaphoreThread(i, semaphore).start();
        }
    }
}

class SemaphoreThread extends Thread {
    private int num;
    private Semaphore semaphore;

    public SemaphoreThread(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("����"+this.num+"ռ��һ������������...");
            Thread.sleep(2000);
            System.out.println("����"+this.num+"�ͷų�����");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
