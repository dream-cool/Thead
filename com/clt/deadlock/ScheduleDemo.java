package com.clt.deadlock;
  
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
    �˽�
  Timer() 
  schedule(TimerTask task, Date time) 
  schedule(TimerTask task, Date firstTime, long period) 
  ��ѧ quartz
 * @author Administrator
 *
 */
public class ScheduleDemo {
  
       /**
        * @param args
        */
       public static void main(String[] args) {


              System.out.println();
       }
       public static void testScheduledThreadPool(){
              ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(3);
              scheduledThreadPool.schedule(() -> System.out.println("�ӳ� 1 ���ִ��"), 1, TimeUnit.SECONDS);
              scheduledThreadPool.scheduleAtFixedRate(()->
                      System.out.println("�ӳ�һ���ÿ����ִ��һ��"),1,3,TimeUnit.SECONDS);
       }

       public static void testTime(){
              Timer timer = new Timer();
              timer.schedule(new TimerTask(){
                     @Override
                     public void run() {
                            System.out.println("�ӳ� 1 ���ִ��");
                     }
              },1);
              timer.schedule(new TimerTask(){
                     @Override
                     public void run() {
                            System.out.println("�ӳ�һ���ÿ����ִ��һ��");
                     }
              },1000,3000);

       }


  
}