package com.example.leetcode.codetop;

/**
 * @author: hzp
 * @date: 2022/5/30
 * @description:
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {

        // 从[i,j]
        int max = nums[0];
        int curMaxSqz = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 连续的值和当前的值比
            curMaxSqz = Math.max(curMaxSqz + nums[i], nums[i]);

            max = Math.max(curMaxSqz, max);

        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {5,4,-1,7,8};
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(nums));

    }
}
