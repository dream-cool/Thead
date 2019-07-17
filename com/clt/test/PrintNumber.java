package com.clt.test;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 20:19 2019/7/15
 */
public class PrintNumber {

    public static void main(String[] args) {
        Number t = new Number();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }

}
class Number implements Runnable{

    public volatile int i = 0 ;

    @Override
    public void run() {
        while (i < 100 ) {
            synchronized (this){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
                if (i < 100){
                    System.out.println(Thread.currentThread().getName()+i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

