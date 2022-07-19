package com.example.leetcode.codetop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、海量日志数据，提取出某日访问百度次数最多的那个IP。
 *
 * 首先是这一天，并且是访问百度的日志中的IP取出来，逐个写入到一个大文件中。注意到IP是32位的，最多有个2^32个IP。同样可以采用映射的方法，
 * 比如模1000
 * ，把整个大文件映射为1000个小文件，再找出每个小文中出现频率最大的IP（可以采用hash_map进行频率统计，然后再找出频率最大的几个）及相应的频率
 * 。然后再在这1000个最大的IP中，找出那个频率最大的IP
 *
 *
 */
public class IPReader {
    static String fileLoc = "/Users/huzepeng/IdeaProjects/leetcode/src/main/resources/ip/bigdata_ip.txt";

    public static void findIp() throws IOException, ClassNotFoundException, InterruptedException {
//        long start = System.currentTimeMillis();
//        hashToSmallFiles();
//        long end1 = System.currentTimeMillis();
//        System.out.println("将大文件映射成小文件，用时：" + (end1 - start) + "毫秒");

        System.out.println("映射到小文件完成，开始统计每个小文件中出现频率最高的ip");
        long start1 = System.currentTimeMillis();
        List<IP> list = countEverySmallFile();
        long end2 = System.currentTimeMillis();
        System.out.println("统计所有文件共用时：" + (end2 - start1) + " 毫秒");

//        System.out.println("统计完成，开始计算所有ip中出现频率最高的ip");
//        IP ip = calculateResult(list);
//        System.out.println("访问次数最多的ip是：" + ip.getIp() + ":" + ip.getCount());
//        long end = System.currentTimeMillis();
//        System.out.println("公用时：" + (end - start) + "毫秒");
    }

    /**
     * 从每个文件出现频率最高ip中，计算出所有文件中出现频率最高ip。
     *
     * @param list
     */
    private static IP calculateResult(List<IP> list) {
        IP[] ips = new IP[list.size()];
        ips = list.toArray(ips);
        int max = 0;
        for (int j = 1; j < ips.length; j++) {
            if (ips[j].getCount() > ips[max].getCount()) {
                max = j;
            }
        }
        return ips[max];
    }

    /**
     * 统计生成的每一个小文件，返回一个List,这个List的每一项就是每个小文件的统计结果，即每个小文件中出现频率最高的ip和出现次数
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static List<IP> countEverySmallFile() throws FileNotFoundException, IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(8+1);//创建一个固定的线程池
        List<IP> list = Collections.synchronizedList(new LinkedList<>());
//        CountDownLatch latch = new CountDownLatch(1024);

        for (int i = 0; i < 1024; i++) {
            File file = new File(fileLoc + i + ".txt");
//            int finalI = i;
            taskcountEverySmallFile(list, file, i);
//            executorService.execute(() -> {
//                taskcountEverySmallFile(list, file, finalI);
//                latch.countDown();
//            });

        }
//        executorService.
//        System.out.println("多线程");
//        latch.await();
        executorService.shutdown();
        return list;
    }

    public  synchronized static void taskcountEverySmallFile(List<IP> list,File file,int i) {
        if (file.exists()) {
            long startTime = System.currentTimeMillis();
            BufferedReader br1 = null;
            try {
                br1 = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String ip1;
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            while (true) {
                try {
                    if ((ip1 = br1.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (!hm.containsKey(ip1)) {
                    hm.put(ip1, 1);
                } else {
                    hm.put(ip1, hm.get(ip1) + 1);
                }
            }
            IP[] ips = new IP[hm.size()];
            int index = 0;
            for (String temp : hm.keySet()) {
                ips[index] = new IP(temp, hm.get(temp));
                index++;
            }
            int max = 0;
            for (int j = 1; j < ips.length; j++) {
                if (ips[j].getCount() > ips[max].getCount()) {
                    max = j;
                }
            }
            list.add(ips[max]);
            long endTime = System.currentTimeMillis();
            System.out.println("已经统计文件：" + fileLoc + i + ".txt，用时：" + (endTime - startTime) + " 毫秒");
        }

    }


    /**
     * 将打文件hash成1024个小文件
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void hashToSmallFiles() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileLoc));
        String ip;
        HashMap<String, FileWriter> fileWriters = new HashMap<>();
        while ((ip = br.readLine()) != null) {
            int tmp = Math.abs(ip.hashCode() % 1024);
            String fileName = fileLoc + tmp + ".txt";
            FileWriter fw = null;
            if (fileWriters.containsKey(fileName)) {
                fw = fileWriters.get(fileName);
            } else {
                fw = new FileWriter(fileName, true);
                fileWriters.put(fileName, fw);
            }
            fw.write(ip + "\n");
        }
        br.close();
        for (FileWriter ff : fileWriters.values()) {
            ff.close();
        }
    }

    /**
     * 随机生成ip地址，生成大文本文件
     *
     * @throws IOException
     */
    private static void generateFile() throws IOException {
        FileWriter fw = new FileWriter(fileLoc, true);
        for (int i = 0; i < 100000000; i++) {
            for (int j = 0; j < 100000000; j++) {
                fw.write(generateIp() + "\n");
            }
        }
        fw.close();
        System.out.println("done");
    }

    /**
     * 随机生成ip地址
     *
     * @return
     */
    private static String generateIp() {
        StringBuilder ip = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int temp = (int) (Math.random() * 255);
            ip.append(temp).append(".");
        }
        return ip.substring(0, ip.length() - 1);
    }

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
//
//            executorService.execute(() ->{
//                try {
//                    generateFile();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            generateFile();
            findIp();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

