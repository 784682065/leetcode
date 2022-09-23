package com.example.leetcode.codetop.cp;

public class Consumer implements Runnable{
    //消费者
    private Storage storage;
    public Consumer(){

    }
    public Consumer(Storage storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
                storage.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
