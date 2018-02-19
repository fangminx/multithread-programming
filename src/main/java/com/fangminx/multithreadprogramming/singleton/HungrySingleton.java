package com.fangminx.multithreadprogramming.singleton;

/**
 * 饿汉，没有线程安全问题，可能会导致内存浪费
 */
public class HungrySingleton {

    //私有构造
    private HungrySingleton (){}

    private static HungrySingleton instance = new HungrySingleton();

    //不会出现线程安全问题,不满足第3点：
    //1.多线程环境下 √
    //2.必须有共享资源 √
    //3.对资源进行非原子性操作 ×
    public static HungrySingleton getInstance(){
        return instance;
    }
}

class HungryMain{
    public static void main(String[] args) {
        HungrySingleton s1 = HungrySingleton.getInstance();
        HungrySingleton s2 = HungrySingleton.getInstance();
        HungrySingleton s3 = HungrySingleton.getInstance();
        HungrySingleton s4 = HungrySingleton.getInstance();
        //哈希值相同
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
