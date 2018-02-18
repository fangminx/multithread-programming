package com.fangminx.multithreadprogramming.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        TestService ts = ac.getBean(TestService.class);

        ts.a();
        ts.b();
    }
}
