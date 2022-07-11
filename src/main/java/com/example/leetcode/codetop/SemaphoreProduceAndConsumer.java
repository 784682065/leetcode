package com.example.leetcode.codetop;


import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreProduceAndConsumer {

    //缓冲区初始化为0
    private static Semaphore full = new Semaphore(0);
    //空闲缓冲区，假如为5
    private static Semaphore empty = new Semaphore(5);
    // 互斥锁
    private static Semaphore mutex = new Semaphore(1);
    //用一个list来模拟生产和消费过程，因为需要频繁增删，所以用链表
    private static LinkedList<Object> list = new LinkedList<>();

    //生产者
    public void produce() throws InterruptedException {
        //获取空缓冲区
        empty.acquire();
        //进入临界区
        mutex.acquire();
        //生产数据
        list.add(new Object());
        System.out.println("add " + list.size());
        //离开临界区，释放互斥信号量
        mutex.release();
        //提供产品，产品缓冲区+1
        full.release();
    }

    //消费者
    public void consumer() throws InterruptedException {
        //获取满缓冲区
        full.acquire();
        //进入临界区
        mutex.acquire();
        //消费数据
        list.remove();
        System.out.println("remove " + list.size());
        //离开临界区，释放互斥信号量
        mutex.release();
        //提供产品，产品缓冲区+1
        empty.release();
    }

    public static void main(String[] args) {

        Thread cthread = new Thread(() -> {
            SemaphoreProduceAndConsumer semaphoreProduceAndConsumer = new SemaphoreProduceAndConsumer();
            while (true) {
                try {
                    semaphoreProduceAndConsumer.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread pthread = new Thread(() -> {
            SemaphoreProduceAndConsumer semaphoreProduceAndConsumer = new SemaphoreProduceAndConsumer();
            while (true) {
                try {
                    semaphoreProduceAndConsumer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        pthread.start();
        cthread.start();
    }
}
