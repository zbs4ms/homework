package com.pool;

import lombok.extern.log4j.Log4j;

/**
 * Created by zbs on 2017/2/13.
 */
@Log4j
public class Handle implements Runnable{

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        } catch (InterruptedException e) {
            log.error("线程sleep出现异常:::",e);
        }
    }
}
