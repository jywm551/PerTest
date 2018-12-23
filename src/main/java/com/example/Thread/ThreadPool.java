package com.example.Thread;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by Theodore_YU on 2017/12/11.
 */
public class ThreadPool {
    @Test
    public void t1(){
        System.out.println(t2());
    }



    private String t2(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(5);
        taskExecutor.setCorePoolSize(10);
        taskExecutor.initialize();
            taskExecutor.execute(new MessagePrinterTask("Message"));
        return "success";
    }
}

class MessagePrinterTask implements Runnable {
    private String message;
    MessagePrinterTask(String message) {
        this.message = message;
    }
    public void run() {
        System.out.println(message);
    }
}
