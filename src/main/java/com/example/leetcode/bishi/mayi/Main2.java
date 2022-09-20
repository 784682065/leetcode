package com.example.leetcode.bishi.mayi;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n + 1];
        Arrays.fill(nums, 1);

        List<ArrayList<Integer>> trees = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            trees.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            ArrayList<Integer> list = trees.get(a);
            list.add(b);
            trees.set(a, list);
        }

        long res = 0;
        for (int i = 1; i < trees.size(); i++) {
            int key = i;
            ArrayList<Integer> value = trees.get(i);
            if (nums[key] != key) {
                int dif = key - nums[key];
                nums[key] = key;
                res += dif;
                for (int v : value) {
                    nums[v] += dif;
                }
            }
        }


        System.out.println(res);
    }
}
