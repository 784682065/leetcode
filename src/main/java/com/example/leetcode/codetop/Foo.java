package com.example.leetcode.codetop;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * leetcode 1114
 *
 */
class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);
    private AtomicInteger secondJobDone = new AtomicInteger(0);
    // 用volatile 也可以,不过他不保证原子性.
    private volatile  Integer first = 0;



    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}

