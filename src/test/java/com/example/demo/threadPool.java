package com.example.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Theodore_YU on 2017/12/8.
 */
public class threadPool {
    public void ThreadPoolFactory(){
        new ThreadPoolExecutor(2,10,2,
                TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5));
    }
}
