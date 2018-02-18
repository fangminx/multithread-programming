package com.fangminx.multithreadprogramming.lambda;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10,20,30,40);
        int res = new Demo().add(values);

        System.out.println("计算结果：");
        System.out.println(res);
    }

    public int add(List<Integer> values){

        System.out.println("stream forEach:");
        values.stream().forEach(System.out :: println);

        System.out.println("parallelStream forEach:");
        values.parallelStream().forEach(System.out :: println);

        System.out.println("parallelStream forEachOrdered:");
        values.parallelStream().forEachOrdered(System.out :: println);

        return values.parallelStream().mapToInt(i -> i * 2).sum();
    }
}
