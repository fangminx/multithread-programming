package com.fangminx.multithreadprogramming.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

//使用spring进行多线程控制，异步方式
@Configuration
@ComponentScan("com.fangminx.multithreadprogramming.spring")
@EnableAsync
public class Config {
}
