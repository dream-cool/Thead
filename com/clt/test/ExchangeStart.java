package com.clt.test;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 22:53 2019/7/15
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
                            System.out.println("轮到线程一开始执行");
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //线程1执行一秒
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
                        System.out.println("轮到线程二开始执行");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //线程1执行一秒
                    state=1;
                    t.notifyAll();
                }
            }
        }).start();
    }
}
