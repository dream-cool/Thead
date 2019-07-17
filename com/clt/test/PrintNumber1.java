package com.clt.test;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:10 2019/7/16
 */
public class PrintNumber1 {
    public static void main(String[] args) {
        Num num = new Num();
        new Thread(num,"线程一").start();
        new Thread(num,"线程二").start();
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
                if (Thread.currentThread().getName().equals("线程一")&&i%2 == 0){
                    System.out.println(Thread.currentThread().getName()+i);
                    i++;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (Thread.currentThread().getName().equals("线程二")&&i%2 != 0){
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
