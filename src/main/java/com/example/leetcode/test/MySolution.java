package com.example.leetcode.test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  上午 11:09 18/3/2022
 * @param:
 */
public class MySolution {

    public void top50(String[] paths) {
        add(paths, 3);
    }

    /**
     * @param paths 文件路径
     * @param k     top k
     * @return
     */
    public void add(String[] paths, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<String> pathArray = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        Collections.addAll(pathArray, paths);

        pathArray.parallelStream().forEach(
                p -> {
                    File file = new File(p);
                    InputStreamReader inputReader = null;
                    try {
                        inputReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                        BufferedReader bf = new BufferedReader(inputReader);
                        // 按行读取字符串
                        String str;
                        while ((str = bf.readLine()) != null) {
                            // 修改为优先队列
                            Integer num = Integer.valueOf(str);
                            vector.add(num);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        vector.parallelStream().forEach(
                num -> {
                    if (queue.size() < k) {
                        queue.add(num);
                    } else {
                        Integer peek = queue.peek();
                        if (peek >= num) {
                        } else {
                            queue.poll();
                            queue.add(num);
                        }
                    }
                }
        );
        queue.forEach(System.out::println);
    }


    public static void main(String[] args) throws IOException {

        String path = "D:\\IDEAworkspace\\leetcode\\src\\main\\java\\com\\example\\leetcode\\data1.txt";
        String[] paths = new String[5];
        Arrays.fill(paths, path);

        MySolution mySolution = new MySolution();
        mySolution.top50(paths);
    }
}
