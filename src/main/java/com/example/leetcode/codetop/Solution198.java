package com.example.leetcode.codetop;

public class Solution198 {

    public int rob(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 前面可以偷的最大的
        for (int i = 2; i < nums.length; i++) {
            // 拿到隔壁的最大的
            nums[i] = nums[i] + nums[i - 2];
            // 可以转变了
            nums[i - 1] = Math.max(nums[i - 1], nums[i - 2]);
        }


        return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        solution198.rob(new int[]{1,2,3,1});
    }

}
