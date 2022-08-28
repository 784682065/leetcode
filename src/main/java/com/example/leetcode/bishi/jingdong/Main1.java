package com.example.leetcode.bishi.jingdong;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        // 找奇数出现最多的次数的值 偶数出现的次数最多的值
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        int maxCount1 = 0, mcv1 = 0, maxCount2 = 0, mcv2 = 0;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if ((i + 1) % 2 == 0) {
                Integer orDefault = map1.getOrDefault(nums[i], 0);
                ++orDefault;
                map1.put(nums[i], orDefault);
                if (orDefault > maxCount1) {
                    mcv1 = nums[i];
                    maxCount1 = orDefault;
                }
            } else {
                Integer orDefault = map2.getOrDefault(nums[i], 0);
                ++orDefault;
                map2.put(nums[i], orDefault);
                if (orDefault > maxCount2) {
                    mcv2 = nums[i];
                    maxCount2 = orDefault;
                }
            }
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        int ans = n - maxCount1 - maxCount2;
        if (mcv2 != mcv1) {
            System.out.println(ans);
            return;
        }


        List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map1.entrySet());
        List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(map2.entrySet());
        list1.sort((a, b) -> b.getValue() - a.getValue());
        list2.sort((a, b) -> b.getValue() - a.getValue());

        if (list1.get(0).getKey() == list2.get(0).getKey()) {
            if (list1.size() == 1 && list1.size() == list2.size()) {
                ans = n / 2;
            } else if (list1.size() == 1) {
                ans = n - maxCount1 - list2.get(1).getValue();
            } else if (list2.size() == 1) {
                ans = n - maxCount2 - list1.get(1).getValue();
            } else {
                ans = Math.min(n - maxCount1 - list2.get(1).getValue(),
                        n - maxCount2 - list1.get(1).getValue());
            }
        }

        System.out.println(ans);
    }
}
