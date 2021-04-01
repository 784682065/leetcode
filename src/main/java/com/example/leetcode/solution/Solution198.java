package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-23 15:50
 */
public class Solution198 {

    public static void main(String[] args) {
        int[] ints = {2,1,1,2};
        System.out.println(rob(ints));
    }

    public static int rob(int[] nums) {

        int length = nums.length;
        if (length == 0 ) return 0;
        if (length == 1 ) return nums[0];

        int[] dp = new int[nums.length];

        //1.0 初始化
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i -1; j++) {
                dp[i] = Math.max(dp[j] + nums[i],dp[i]);
            }
        }

        int max = Math.max(dp[dp.length-1],dp[dp.length-2]);
        return max;
    }
}
