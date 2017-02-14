package com.pool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zbs on 2017/2/13.
 */

public class CachedThreadPool {

    public ExecutorService cachedThreadPool = null;

    public CachedThreadPool(){
            this.cachedThreadPool = Executors.newCachedThreadPool();
    }

    public void execute(){
        cachedThreadPool.execute(new Handle());
    }
}
