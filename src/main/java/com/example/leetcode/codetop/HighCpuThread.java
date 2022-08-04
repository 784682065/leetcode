package com.example.leetcode.codetop;

public class HighCpuThread {

    public static void main(String[] args)  {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(30 * 60 * 1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
            thread.setName("thread-" + i);
            thread.start();
        }

        Thread highCpuThread = new Thread(() -> {
            int i = 0 ;
            while (true) {
                i++;
            }
        });
        highCpuThread.setName("HighCpu");
        highCpuThread.start();
    }

}
