package com.fangminx.multithreadprogramming.volatileAndSynchronized;

public class VolatileDemo {

    public volatile int a = 1;

    /**
     * volatile不能保证非原子性操作，
     * synchronized可以取代volatile，volatile不可以取代synchronized
     * @return
     */
    public synchronized int getA(){
        return a++;
    }
}

class VolatileDemoMain {
    public static void main(String[] args) {
        //多个线程必须拿的是同一个锁，也就是同一个对象

        VolatileDemo demo = new VolatileDemo();

        demo.a=10;

        new Thread(()->{
            System.out.println(demo.a);
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印最终结果：
        System.out.println(demo.a);
    }
}