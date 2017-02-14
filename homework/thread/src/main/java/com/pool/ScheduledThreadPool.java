package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zbs on 2017/2/13.
 */
public class ScheduledThreadPool {

    public ExecutorService scheduledThreadPool = null;

    public ScheduledThreadPool(int maxlength){
        this.scheduledThreadPool = Executors.newScheduledThreadPool(maxlength);
    }

    public void execute(){
        scheduledThreadPool.execute(new Handle());
    }


}
