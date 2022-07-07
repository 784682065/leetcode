package com.example.leetcode.codetop;

public class Solution704 {

    public int search(int[] nums, int target) {


        int left = 0, right = nums.length -1;

        while (left <= right) {
            // 避免溢出
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
