package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2021/11/16
 * @description:
 */
public class Solution45 {


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,2,3};
        Solution45 solution45 = new Solution45();
        int jump = solution45.jump_office(nums);
        System.out.println(jump);
    }

    public int jump(int[] nums) {

        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int index = 0;
        int count = 1;
        int total = nums[0];

        while (total < len - 1) {
            int val = nums[index];
            int length = Math.min(index + val, len - 1);
            int max = Integer.MIN_VALUE;
            int pos = 0;
            // 每次找最大的跳. 其中索引的位置和值的大小都要考虑
            for (int i = index + 1; i <= length; i++) {
                if (nums[i] == 0) continue;

                int cur = nums[i] + i;
                if (max < cur) {
                    max = cur;
                    pos = i;
                }
            }

            // 每次计算能够跳到的最大位置
            total += nums[pos] - nums[index] + pos - index;
            // 找到最大的位置就跳到这
            index = pos;
            count++;
        }

        return count;
    }


    public int jump_office(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i = 0; i < length - 1; i++) {
            // 每次在 i 和end 这个区间内找能跳到的最大位置
            // 前面怎么跳的完全可以忽略
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}