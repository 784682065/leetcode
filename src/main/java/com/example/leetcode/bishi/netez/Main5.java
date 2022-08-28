package com.example.leetcode.bishi.netez;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//10
//3 1 3 1 3 1 2 1 3 2
//76
public class Main5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        long res = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = arr[i];
            int lt = map.get(left) - 1;
            map.put(left, lt);
            if (lt == 0){
                continue;
            }
            Map<Integer, Integer> newMap = new HashMap<>(map);
            for (int j = i+1; j < n - 1; j++) {
                int mid = arr[j];
                // 过了当前数字,还剩下多少个数字
                newMap.put(mid, map.get(mid) -1);
                if (left > mid){
                    // k的数量
                    res+= newMap.get(left);
                }
            }
        }

//        for (int i = 0; i < n - 1; i++) {
//            int count = 0;
//            for (int j = i+1; j < n; j++) {
//                if (arr[i] == arr[j]){
//                    res += count;
//                }else if (arr[j] < arr[i]){
//                    count++;
//                }
//            }
//
//        }

        System.out.println(res);
    }
}
