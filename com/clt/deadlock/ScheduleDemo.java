package com.clt.deadlock;
  
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
    了解
  Timer() 
  schedule(TimerTask task, Date time) 
  schedule(TimerTask task, Date firstTime, long period) 
  自学 quartz
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
              scheduledThreadPool.schedule(() -> System.out.println("延迟 1 秒后执行"), 1, TimeUnit.SECONDS);
              scheduledThreadPool.scheduleAtFixedRate(()->
                      System.out.println("延迟一秒后每三秒执行一次"),1,3,TimeUnit.SECONDS);
       }

       public static void testTime(){
              Timer timer = new Timer();
              timer.schedule(new TimerTask(){
                     @Override
                     public void run() {
                            System.out.println("延迟 1 秒后执行");
                     }
              },1);
              timer.schedule(new TimerTask(){
                     @Override
                     public void run() {
                            System.out.println("延迟一秒后每三秒执行一次");
                     }
              },1000,3000);

       }


  
}