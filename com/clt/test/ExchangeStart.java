package com.clt.test;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 22:53 2019/7/15
 */
public class ExchangeStart {
    private static  int state = 1;

    public static void main(String[] args) {
        final ExchangeStart t=new ExchangeStart();
        new Thread( ()-> {
                while (true) {
                    synchronized (t) {
                        if (state != 1) {
                            try {
                                t.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            System.out.println("�ֵ��߳�һ��ʼִ��");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //�߳�1ִ��һ��
                        state=2;
                        t.notifyAll();
                    }
                }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (t) {
                    if (state != 2) {
                        try {
                            t.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        System.out.println("�ֵ��̶߳���ʼִ��");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //�߳�1ִ��һ��
                    state=1;
                    t.notifyAll();
                }
            }
        }).start();
    }
}
