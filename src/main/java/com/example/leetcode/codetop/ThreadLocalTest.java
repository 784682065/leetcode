package com.example.leetcode.codetop;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalTest implements Runnable{
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));
    private static final ThreadLocal<String> threadId = ThreadLocal.withInitial(() -> "aaaa");
    private static final ThreadLocal<String> threadId1 = ThreadLocal.withInitial(() -> "aaaa");

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest obj = new ThreadLocalTest();

        for (int i = 0; i < 10; i++) {
//            ThreadLocalTest.threadId.set(i);
            Thread t = new Thread(obj,"" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }


    }

    @Override
    public void run() {

        threadId.set("cccc");
        threadId1.set("ccc1c");
        System.out.println(threadId.get());
        System.out.println(threadId1.get());

//        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get().toPattern());
//        try {
//            Thread.sleep(new Random().nextInt(1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //formatter pattern is changed here by thread, but it won't reflect to other threads
//        formatter.set(new SimpleDateFormat());
//
//        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get().toPattern());
    }
}
