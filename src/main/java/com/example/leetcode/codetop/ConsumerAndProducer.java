package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

public class ConsumerAndProducer {

    int QueueSize = 4;
    BlockingQueue<Integer> queue;
    Queue<Integer> commonQueue;

    ExecutorService executorService0;
    ExecutorService executorService1;


    class Consumer implements Runnable {

        @Override
        public void run() {
//            Semaphore semaphore = new Semaphore(QueueSize);
            while (true) {
                try {

//                    semaphore.acquire();
                    queue.take();
                    System.out.println("Consumer one" + queue.size());

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                finally {
//                    semaphore.release();
//                }
            }

        }
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    if (queue.offer(1, 10, TimeUnit.SECONDS)) {
                        System.out.println("Produce one" + queue.size());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void DoCp() {

        executorService0 = Executors.newCachedThreadPool();
        executorService1 = Executors.newCachedThreadPool();
        queue = new ArrayBlockingQueue<>(QueueSize);
//        commonQueue = new Lin<>();

        executorService0.submit(new Consumer());
        executorService1.submit(new Producer());

    }

    public static void main(String[] args) {
        ConsumerAndProducer consumerAndProducer = new ConsumerAndProducer();
        consumerAndProducer.DoCp();
    }
}
