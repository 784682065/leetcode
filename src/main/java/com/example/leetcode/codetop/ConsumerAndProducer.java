package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.*;

public class ConsumerAndProducer {

    int QueueSize = 10;
    BlockingQueue<Integer> queue;


    ExecutorService executorService0;
    ExecutorService executorService1;


    class Consumer implements Runnable {

        @Override
        public void run() {
//            final Semaphore semaphore = new Semaphore(QueueSize);
            while (true) {
                try {
//                    semaphore.acquire();
                    queue.take();
//                    Thread.sleep(10);
                    System.out.println("Consumer one" + queue.size());
                    System.out.println("Consumer one"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
//                    semaphore.release();
                }
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
                        System.out.println("Produce one"+ Thread.currentThread().getName());
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
        executorService1.execute(new Producer());
        for (int i = 0; i < 10; i++) {
            executorService0.execute(new Consumer());
        }


    }

    public static void main(String[] args) {
        ConsumerAndProducer consumerAndProducer = new ConsumerAndProducer();
        consumerAndProducer.DoCp();

//
    }
}
