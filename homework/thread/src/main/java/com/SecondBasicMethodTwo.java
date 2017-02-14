package com;

/**
 * Created by zbs on 2017/2/12.
 */
public class SecondBasicMethodTwo implements Runnable{

    private String name;

    public SecondBasicMethodTwo(String name){
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+" -- "+i);
        }
    }

    public static void main(String[] args) {
        int i = 5;
        while (i>0) {
            SecondBasicMethodTwo thread = new SecondBasicMethodTwo("Thread-"+i);
            new Thread(thread).start();
            i--;
        }
    }
}
