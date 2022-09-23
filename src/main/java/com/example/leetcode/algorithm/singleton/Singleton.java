package com.example.leetcode.algorithm.singleton;

public class Singleton {

    // 加个static 加个volatile
    private volatile static   Singleton singleton;

    // 构造方法一定要private,这样才能防止被人使用
    private Singleton(){}

    public Singleton getInstance(){
        if (singleton ==null){
            // 这里要锁定class
            synchronized (Singleton.class){
                if (singleton ==null){
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

}
