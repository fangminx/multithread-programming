package com.fangminx.multithreadprogramming.volatileAndSynchronized;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class VolatileDemo {

    public volatile int a = 1;

    //使用原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int [] s = {2,1,4,6};
    AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(s);

    /**
     * volatile不能保证非原子性操作，a++为非原子性操作
     * synchronized可以取代volatile，volatile不可以取代synchronized
     * @return
     */
    public synchronized int getA(){
        return a++;
    }

    /**
     * 使用原子类保证原子性操作
     * @return
     */
    public int getValueNext(){
        return atomicInteger.getAndIncrement(); //底层使用cas(compareAndSet)操作
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