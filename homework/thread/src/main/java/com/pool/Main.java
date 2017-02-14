package com.pool;

/**
 * Created by zbs on 2017/2/13.
 */
public class Main {

    public static void main(String[] args) {
        CachedThreadPool cachedThreadPool = new CachedThreadPool();
        int i = 10;
        while (i > 0) {
            cachedThreadPool.execute();
            i--;
        }
        FixedThreadPool fixedThreadPool = new FixedThreadPool(2);
        while (i < 10) {
            fixedThreadPool.execute();
            i++;
        }
        ScheduledThreadPool scheduledThreadPool = new ScheduledThreadPool(3);
        while (i > 0) {
            scheduledThreadPool.execute();
            i--;
        }
        SingleThread singleThread = new SingleThread();
        while (i < 10) {
            singleThread.execute();
            i++;
        }
    }

}
