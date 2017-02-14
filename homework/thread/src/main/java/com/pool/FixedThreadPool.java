package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zbs on 2017/2/13.
 */

public class FixedThreadPool {

    public ExecutorService fixedThreadPool = null;

    public FixedThreadPool(int maxlength){
        this.fixedThreadPool = Executors.newFixedThreadPool(maxlength);
    }

    public void execute(){
        fixedThreadPool.execute(new Handle());
    }

}
