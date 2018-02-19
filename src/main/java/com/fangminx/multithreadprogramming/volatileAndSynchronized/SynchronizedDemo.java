package com.fangminx.multithreadprogramming.volatileAndSynchronized;

public class SynchronizedDemo {

    private int a = 1;

    //Getter&Setter方法都加上synchronized 锁的是当前类对象，setA方法执行完后，才能进行getA方法的调用，保证了可见性
    public int getA() {
        return a;
    }

    public void setA(int a) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.a = a;
    }
}

class SynchronizedDemoMain {
    public static void main(String[] args) {
        //多个线程必须拿的是同一个锁，也就是同一个对象

        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(()->{
            demo.setA(10);
        }).start();

        new Thread(()->{
            //Getter&Setter方法都加上synchronized后，和最终结果一致
            System.out.println(demo.getA());
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //打印最终结果：
        System.out.println(demo.getA());
    }
}