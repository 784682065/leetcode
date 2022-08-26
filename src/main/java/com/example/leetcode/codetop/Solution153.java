package com.example.leetcode.codetop;

public class Solution153 {
    // 左边的值比他大就是最小的元素
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = (right - left) / 2 + left;
            // 是最大值
            if ((mid ==0 || nums[mid] > nums[mid - 1]) &&
                    (mid == (nums.length - 1) || ( nums[mid] > nums[mid + 1]))) {
                return nums[mid + 1];
            }
            // 是最小值
            if ( (mid ==0 || nums[mid] < nums[mid - 1]) &&
                    (mid == (nums.length - 1) || ( nums[mid] < nums[mid + 1]))) {
                return nums[mid];
            }

            // 不然就跟start和end 比
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = { 3,4,5,1};
        Solution153 solution153 = new Solution153();
        System.out.println(solution153.findMin(nums));
    }


}
