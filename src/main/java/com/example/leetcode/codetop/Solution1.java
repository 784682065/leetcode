package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }

            map.put(nums[i], i);
        }


        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        Solution1 solution1 = new Solution1();
        solution1.twoSum(nums, 9);
    }

}
