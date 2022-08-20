package com.example.leetcode.solution;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        double ans = Integer.MIN_VALUE;
        // 求前缀差和
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[] diffSum = new int[nums.length];
        diffSum[k - 1] = preSum[k - 1];
        ans =  diffSum[k - 1];
        for (int i = k; i < nums.length; i++) {
            diffSum[i] = preSum[i] - preSum[i - k];
            ans = Math.max(ans,diffSum[i]);
        }
        return ans / k;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 5, 8, 8, 3, 9, 8, 7, 6};
//        int[] nums = {-1};
        int k = 7;
        Solution643 solution643 = new Solution643();
        System.out.println(solution643.findMaxAverage(nums, k));
    }
}
