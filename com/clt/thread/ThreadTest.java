package com.clt.thread;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 16:45 2019/7/15
 */
public class ThreadTest extends  Thread {
    public static void main(String[] args) {
        new ThreadTest().start();

    }

    @Override
    public void run() {
        System.out.println("�߳̿�ʼִ��");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�߳�ִ�н���");
    }
}
