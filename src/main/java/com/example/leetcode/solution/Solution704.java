package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/4/6
 * @description:
 */
public class Solution704 {

    public int search(int[] nums, int target) {

        return binarySeacher(nums, 0, nums.length - 1, target);
    }


    public int binarySeacher(int[] nums, int left, int right, int target) {

        int pos = -1;
        while (left > right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                pos = mid;
                break;
            } else if (nums[mid] > target) {
                // 如果大的话就去左边找
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        Solution704 solution704 = new Solution704();
        int search = solution704.search(nums, 2);
        System.out.println(search);

    }
}
