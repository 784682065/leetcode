package com.example.leetcode.meituan;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());

//        List<List<String>> lists = new ArrayList<>();
        String[] x = scanner.nextLine().split(" ");
        String[] y = scanner.nextLine().split(" ");


        System.out.println(reversMagicStone(x, y));


    }


    public static long reversMagicStone(String[] x, String[] y) {

        // key 为数组的值, V为该值的计数
        Map<String, Integer> map = new HashMap<>();
        int length = x.length;
        for (int i = 0; i < length; i++) {
            int count = map.getOrDefault(x[i], 0) + 1;
            map.put(x[i], count);
            if (count > (length / 2)) {
                return 0;
            }
        }




        return -1;
    }
}
