package com.example.leetcode.algorithm.observer;

public class Main {


    public static void main(String[] args) {

        Subject subject = new Subject();
        new MessagesObserver(subject);
        new WechatObserver(subject);



        System.out.println("doing something");
        subject.notifyAllObservers();
    }
}
