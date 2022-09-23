package com.example.leetcode.algorithm.observer;

public class MessagesObserver extends Observer {

    public MessagesObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void call() {
        System.out.println("send messages");
    }

}
