package com.clt.deadlock;


/**
 * 过多的同步方法可能造成死锁
 * @author Administrator
 *
 */
public class DeadLockTest {
       /**
        * @param args
        */
       public static void main(String[] args) {
              Object g =new Object();
              Object m = new Object();
              Test t1 =new Test(g,m);
              Test2 t2 = new Test2(g,m);
              Thread proxy = new Thread(t1);
              Thread proxy2 = new Thread(t2);
//              System.out.println("chuxian ");
              proxy.start();
              proxy2.start();
//              System.out.println("chuxian ");
       }
  
}
class Test implements Runnable{
       Object goods ;
       Object money ;
       boolean flag=true;
       
       public Test(Object goods, Object money) {
              super();
              this.goods = goods;
              this.money = money;
       }
  
       @Override
       public void run() {
              while(flag){
                     test();
              }
       }    
       public void test(){
              synchronized(goods){
            	  System.out.println("1");
						
                    
                     
              }
			  synchronized(money){
             	 System.out.println("11");
                               
              } 
              
              System.out.println("一手给钱");
              this.flag=false;
       }    
}
class Test2  implements Runnable{
       Object goods ;
       Object money ;
       boolean flag=true;
       public Test2(Object goods, Object money) {
              super();
              this.goods = goods;
              this.money = money;
       }
       @Override
       public void run() {
              while(flag){
                     test();
              }
       }    
       public void test(){
              synchronized(money){
            	  
            	  System.out.println("2");
		            		
                   
                     
              }
              synchronized(goods){
             	 System.out.println("22");
              }
              System.out.println("一手给货");
              this.flag=false;
       }    
}