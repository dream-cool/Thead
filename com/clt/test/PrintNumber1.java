package com.clt.test;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 8:10 2019/7/16
 */
public class PrintNumber1 {
    public static void main(String[] args) {
        Num num = new Num();
        new Thread(num,"�߳�һ").start();
        new Thread(num,"�̶߳�").start();
    }
}
class Num implements Runnable{
    public volatile int i = 0;

    @Override
    public void run() {
        while (i < 100){
            synchronized (this){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
                if (Thread.currentThread().getName().equals("�߳�һ")&&i%2 == 0){
                    System.out.println(Thread.currentThread().getName()+i);
                    i++;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Thread.currentThread().getName().equals("�̶߳�")&&i%2 != 0){
                    System.out.println(Thread.currentThread().getName()+i);
                    i++;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
