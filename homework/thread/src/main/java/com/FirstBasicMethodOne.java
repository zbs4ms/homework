package com;

/**
 * 基本方式1
 * Created by zbs on 2017/2/12.
 */
public class FirstBasicMethodOne extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName()+" -- "+i);
        }
    }

    public static void main(String[] args) {
        int i = 5;
        while (i>0) {
            new FirstBasicMethodOne().start();
            i--;
        }
    }
}
