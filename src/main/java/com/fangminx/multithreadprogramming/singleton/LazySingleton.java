package com.fangminx.multithreadprogramming.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 懒汉，会出现线程安全问题
 */
public class LazySingleton {

    private LazySingleton() {}

    //加上volatile 防止指令重排序
    private static volatile LazySingleton instance;

    //会出现线程安全问题,满足3点：（加上synchronized可以保证线程安全）
    //1.多线程环境下 √
    //2.必须有共享资源 √
    //3.对资源进行非原子性操作 √
    public static LazySingleton getInstance(){
        // 自旋
        if(instance == null) {
            //模拟出更多的实例
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //双重检查加锁
            synchronized (LazySingleton.class) {
                if(instance == null)
                    instance = new LazySingleton(); //可能发生指令重排序，

                    //申请一块内存空间
                    //在这块空间实例化对象
                    //instance的引用指向这块空间地址

            }
        }
        return instance;
    }
}

//单线程情况，不会创建多个实例
class LazyMain{
    public static void main(String[] args) {
        LazySingleton s1 = LazySingleton.getInstance();
        LazySingleton s2 = LazySingleton.getInstance();
        LazySingleton s3 = LazySingleton.getInstance();
        LazySingleton s4 = LazySingleton.getInstance();
        //哈希值相同
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}

//模拟多线程情况
class MultiThreadMain{
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for(int i = 0;i < 20; i++){
//            threadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + ": "+LazySingleton.getInstance());
//                }
//            });
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + ": "+LazySingleton.getInstance());
            });
        }
        threadPool.shutdown();
    }
}