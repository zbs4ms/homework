package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zbs on 2017/2/13.
 */
public class SingleThread {

    public ExecutorService singleThread = null;

    public SingleThread(){
        this.singleThread = Executors.newSingleThreadExecutor();
    }

    public void execute(){
        singleThread.execute(new Handle());
    }
}
