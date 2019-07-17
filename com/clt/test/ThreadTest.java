package com.clt.test;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 23:33 2019/7/15
 */
public class ThreadTest implements Runnable{

    int i = 1;

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("�߳�1");
        t2.setName("�߳�2");

        t1.start();
        t2.start();
    }

    public void run() {
        while (true) {
            synchronized (this) {
                // �Ȼ�������һ���߳�
                notify();
                try {
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":"+ i);
                    i++;
                    try {
                        // ��ӡ��֮���ͷ���Դ���ȴ��´α�����
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
