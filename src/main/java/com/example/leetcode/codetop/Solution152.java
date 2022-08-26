package com.example.leetcode.codetop;

public class Solution152 {
    public int maxProduct(int[] nums) {
        // 规定华东窗口大小
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            ans = Math.max(ans, dp[i]);
        }

        int[] save = dp.clone();
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                save[j] = dp[j] * save[j + 1];
                ans = Math.max(ans, save[j]);
            }
        }
        return ans;
    }

    public int maxProductOF(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
    public int maxProductOF1(int[] nums) {
        int length = nums.length;
        int maxF = nums[0];
        int minF =  nums[0];
        int ans = maxF;
        for (int i = 1; i < length; ++i) {
            // 最大值可能由负数最小值 转换而来
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }

        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {5,6,-3,4,-3};
//        int[] arr = {5,6,-3,4,-3}; // [-4,-3,-2]
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProductOF(arr));
    }
}
