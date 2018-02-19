package com.fangminx.multithreadprogramming.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    private int value;
    Lock lock = new ReentrantLock();

    public int getNext(){
        lock.lock();
        value++;
        lock.unlock();
        return value;
    }
}

class LockDemoMain {
    public static void main(String[] args) {

        LockDemo lockDemo = new LockDemo();

        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for(int i = 0;i < 100; i++){
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + ": "+ lockDemo.getNext());
            });
        }
        threadPool.shutdown();
    }
}
