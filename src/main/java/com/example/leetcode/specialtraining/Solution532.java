package com.example.leetcode.specialtraining;

import java.util.Arrays;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:14 2020/5/14
 * @param:
 */
public class Solution532 {

    public static void main(String[] args) {
        int[] arr = {3,1,4,1,5};

        Solution532 solution532 = new Solution532();
        int pairs = solution532.findPairs(arr, 2);
        System.out.println(pairs);
    }

    public int findPairs(int[] nums, int k) {

        // 1. 排序
        Arrays.sort(nums);

        int start = -10000;
        int end = -10000;
        int count = 0;
        //2.双指针 计算差值
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == start) continue;

            for (int j = i+1; j < nums.length; j++) {

                if (nums[j] == end) continue;
                if (nums[j] - nums[i] == k){
                    end = nums[j];
                    start = nums[i];
                    count++;
                }
                if (nums[j] - nums[i] > k){
                    start = nums[i];
                    break;
                }
            }


        }


        return count;
    }

}
