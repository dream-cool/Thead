package com.clt.test;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 8:24 2019/7/16
 */
public class YieldTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+i);
                    Thread.yield();
                }
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }

}
