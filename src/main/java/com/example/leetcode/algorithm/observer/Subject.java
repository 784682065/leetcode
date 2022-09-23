package com.example.leetcode.algorithm.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<Observer>  observers = new ArrayList<>();


    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){

        for (Observer observer : observers) {
            observer.call();
        }

    }


}
