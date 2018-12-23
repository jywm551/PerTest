package com.example.Thread;

import org.junit.Test;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Theodore_YU on 2017/12/11.
 */
public class ThreadAbout {


    @Test
    public void test() {
        System.out.println(t1());

    }

    // 线程池
    private ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(10);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(20);
        executor.afterPropertiesSet();
        return executor;
    }

    // 可缓存线程池
    private Executor cachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    // 单线程的线程池
    private Executor singleThreadPool() {
        return Executors.newSingleThreadExecutor();
    }

    // 固定大小的线程池
    private Executor fixedThreadPool() {
        return Executors.newFixedThreadPool(5);
    }

    // 大小无限的的线程池
    private Executor scheduledThreadPool() {
        return Executors.newScheduledThreadPool(5);
    }

    private String t1() {
        taskExecutor().submit(this::t2);
        cachedThreadPool().execute(this::t2);
        singleThreadPool().execute(this::t2);
        fixedThreadPool().execute(this::t2);
        scheduledThreadPool().execute(this::t2);
        return "success";
    }

    private void t2() {
        System.out.println("yes");
    }
}
