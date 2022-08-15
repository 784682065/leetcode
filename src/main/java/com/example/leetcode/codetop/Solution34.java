package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null){
            return res;
        }

        int left = 0, right = nums.length - 1;
        int mid;
        int index = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target){
                index = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid -1;

            }else {
                left = mid +1;
            }
        }

        if (index != -1){
            int start = index;
            int end = index;
            while (start >= 0 &&nums[start] == target){
                --start;
            }
            while (end < nums.length &&nums[end] == target){
                ++end;
            }
            res = new int[]{++start, --end};
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Solution34 solution34 = new Solution34();
        System.out.println(Arrays.toString(solution34.searchRange(nums, 6)));

    }

}
