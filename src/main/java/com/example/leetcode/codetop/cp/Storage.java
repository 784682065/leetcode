package com.example.leetcode.codetop.cp;

import java.util.LinkedList;

public class Storage {

    //仓库容量
    private final int MAX_SIZE = 10;
    //仓库存储的载体
    private final LinkedList<Object> list = new LinkedList<>();

    //生产方法
    public void produce() {
        synchronized (list) {
            //判断仓库是否满，满则进入wait阶段
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("生产者" + Thread.currentThread().getName() + "仓库已经满了");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //没有满则可以生产
            list.add(new Object());
            System.out.println("生产者" + Thread.currentThread().getName() + "生产了一个产品，现在库存有" + list.size());
            list.notifyAll();
        }
    }

    public void consume() {
        synchronized (list) {
            //当库存为0则不让消费
            while (list.size() == 0) {
                System.out.println("消费者是" + Thread.currentThread().getName() + "仓库容量为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //不是空则可以消费
            list.remove();
            System.out.println("消费者" + Thread.currentThread().getName() + "消费了一个产品，现在还剩有产品" + list.size());
            list.notifyAll();
        }
    }

}


