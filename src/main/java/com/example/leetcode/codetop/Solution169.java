package com.example.leetcode.codetop;

public class Solution169 {

    public int majorityElement(int[] nums) {
        int[] pre = {nums[0], 1};
        for (int i = 1; i < nums.length; i++) {
            if (pre[0] == nums[i]) {
                pre[1] += 1;
            } else {
                if (pre[1] == 1) {
                    pre[0] = nums[i];
                } else {
                    pre[1] -= 1;
                }
            }
        }
        return pre[0];
    }

    public int majorityElementOF(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
