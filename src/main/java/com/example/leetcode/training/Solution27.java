package com.example.leetcode.training;

import java.util.Arrays;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  23:09 2020/5/14
 * @param:
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {

        Arrays.sort(nums);

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[start] = nums[i];
                start++;
            }

        }

        return start;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


}
