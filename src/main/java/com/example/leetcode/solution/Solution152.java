package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-23 15:13
 */
public class Solution152 {

    public static void main(String[] args) {
        int[] ints = {-2, 0, -1};
        System.out.println(maxProduct(ints));
    }

    public static int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }

        return max;
    }


//    public static int maxProduct1(int[] nums) {
//
//        if (nums.length == 0) return 0;
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0]; //初始化
//        int max = 0;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
//        }
//        return max;
//    }

}
