package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution300 solution300 = new Solution300();
        int length = solution300.lengthOfLIS(nums);
        System.out.println(length);
    }
}
