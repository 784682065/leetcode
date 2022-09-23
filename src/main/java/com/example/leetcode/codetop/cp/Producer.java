package com.example.leetcode.codetop.cp;

public class Producer implements Runnable {
    //生产者类
    private Storage storage;

    public Producer() {

    }

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                storage.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

