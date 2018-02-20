package com.fangminx.multithreadprogramming.threadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor
                (10,20,10, TimeUnit.DAYS,new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.CallerRunsPolicy());

        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 100; i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName());
                count.getAndIncrement();
            });
        }
        threadPool.shutdown();
        while (Thread.activeCount() > 1){

        }
        //会有main线程保证总数为100
        System.out.println(count.get());
    }
}
