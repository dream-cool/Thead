package com.clt.test;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 15:11 2019/7/17
 */
public class DaemonTest3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonT());
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class DaemonT implements Runnable{

    @Override
    public void run() {
        try {
            System.out.println("线程执行");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("线程执行过程发生异常");
            e.printStackTrace();
        } finally {
            System.out.println("finally执行");
        }
    }
}
