package com.example.micha.threadprogress.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by micha on 1/25/2018.
 */

public class ThreadExecutor extends ThreadPoolExecutor {
    private static ThreadExecutor executor;
    private ThreadExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public static ThreadExecutor getInstance(int poolsize, int maxpool, long keepAlive, TimeUnit unit, BlockingQueue<Runnable> workqueue,ThreadFactory factory){
        if(executor == null){
            executor = new ThreadExecutor(poolsize, maxpool, keepAlive, unit, workqueue, factory);
        }
        return executor;
    }
}
