package com.example.leetcode.solution;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: hzp
 * @date: 2022/3/17
 * @description: 1000w个数找最大k个数,或者最小k个数
 */
public class PriorityTest {
    //找到数组中的前k个最小值
    static Queue<Integer> findFirstEndN(int[] data, int k){
        if(data==null || data.length==0)
            return null;

        Queue<Integer> priorityQueue=new PriorityQueue<>(k);
        for(int i=0;i<data.length;i++)
            priorityQueue.add(data[i]);
        return priorityQueue;

    }

    //找到数组中的前k个最大值
    static Queue<Integer> findTopN(int[] data, int k){
        if(data==null || data.length==0)
            return null;



        Queue<Integer> priorityQueue=new PriorityQueue<>(k);
        priorityQueue.add(data[0]);
        for(int i=1;i<data.length;i++){
            if(priorityQueue.size()<k)
                priorityQueue.add(data[i]);
            else if(data[i]>=priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(data[i]);
            }
        }
        return priorityQueue;
    }

    //找到数组中的前k个最小值
    static Queue<Integer> findFirstEndN1(String filePath, int k) throws NumberFormatException, IOException {
        if(filePath==null)
            return null;

        Queue<Integer> priorityQueue=new PriorityQueue<>(k);
        File fileName= new File(filePath);
        BufferedReader bufread= new BufferedReader(new FileReader(fileName));
        String read;
        while((read=bufread.readLine())!=null){
            String[] data=read.split(" ");
            for(int i=0;i<data.length;i++)
                priorityQueue.add(Integer.valueOf(data[i]));
            read=null;
            data=null;
        }

        return priorityQueue;

    }

    // 找到数组中的前k个最大值
    static Queue<Integer> findTopN1(String filePath, int k) throws NumberFormatException, IOException {
        if (filePath == null)
            return null;

        Queue<Integer> priorityQueue = new PriorityQueue<>(k);// 建立一个优先级队列
        File fileName = new File(filePath);
        BufferedReader bufread = new BufferedReader(new FileReader(fileName));// 读入文件
        String read;
        while ((read = bufread.readLine()) != null) {
            String[] data = read.split(" ");
            priorityQueue.add(Integer.valueOf(data[0]));
            for (int i = 1; i < data.length; i++) {
                if (priorityQueue.size() < k)
                    priorityQueue.add(Integer.valueOf(data[i]));
                else if (Integer.valueOf(data[i]) >= priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(Integer.valueOf(data[i]));
                }
            }
            read = null;
            data = null;
        }
        return priorityQueue;
    }

    /**
     *
     * 优先队列,使用小顶堆,通过对堆元素的上浮和下沉,实现了在O(logn)的时间复杂度内插入元素和删除堆顶元素
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {


        int[] data=new int[10000000];
        Random random=new Random();
        for(int i=0;i<data.length;i++)
            data[i]=random.nextInt(10000000);

        int k=15;
        Queue<Integer> priorityQueue=findFirstEndN(data,k);
        Queue<Integer> priorityQueueTop=findTopN(data,k);

        System.out.println("前k个最小的数t为：");

        for(int i=0;i<k;i++)
            System.out.print(priorityQueue.poll() + " ");

        System.out.println("\n前k个最大的数为：");
        for(int i=0;i<k;i++)
            System.out.print(priorityQueueTop.poll() + " ");

//        String path="data1.txt";
//        File text=new File(path);
//        FileWriter textFile=new FileWriter(text);
//        int n=10000000;
//        for(int i=0;i<n;i++)
//            if((i+1)%1000!=0)
//                textFile.write(random.nextInt(10000000) + " ");
//            else
//                textFile.write(random.nextInt(10000000) + "\n");
//
//        Queue<Integer> priorityQueue1=findFirstEndN1(path,k);
//        Queue<Integer> priorityQueueTop1=findTopN1(path,k);
//
//        System.out.println("前k个最小的数为：");
//
//        for(int i=0;i<k;i++)
//            System.out.print(priorityQueue1.poll() + " ");
//
//        System.out.println("\n前k个最大的数为：");
//        for(int i=0;i<k;i++)
//            System.out.print(priorityQueueTop1.poll() + " ");
    }

}
