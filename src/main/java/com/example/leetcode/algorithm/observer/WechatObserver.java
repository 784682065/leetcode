package com.example.leetcode.algorithm.observer;

public class WechatObserver extends Observer{


    public WechatObserver(Subject subject ) {
        this.subject= subject;
        subject.attach(this);
    }

    @Override
    public void call() {
        System.out.println("send wechat");
    }
}
