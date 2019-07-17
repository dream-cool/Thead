package com.clt.test;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 20:16 2019/7/15
 */

public class SaleTicket {

    public static void main(String[] args) throws InterruptedException {
        TestThread t1 = new TestThread(100);
        new Thread(t1, "t1").start();
        new Thread(t1, "t2").start();

    }
}

class TestThread implements Runnable {
    Integer total;


    public TestThread(Integer total) {
        this.total = total;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (total > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "����������" + total-- + "��Ʊ");
                } else break;
            }
        }
    }
}
