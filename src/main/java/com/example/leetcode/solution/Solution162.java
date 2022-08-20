package com.example.leetcode.solution;

public class Solution162 {
    // 只需要找区间最大值
    public int findPeakElement(int[] nums) {
        int left = 0 , right = nums.length-1;
        while (left <= right){
            int mid = left + (right- left)/2;
            int cur = nums[mid];
            // 大于left && 大于right
            if ( ((mid > 0 && cur > nums[mid-1]) || mid == 0) && ((mid < nums.length-1 && cur > nums[mid+1]) || mid == nums.length-1)){
                return mid;
            } else if (mid > 0 && cur < nums[mid-1] ) {
                // 往左边走
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution162 solution162 = new Solution162();
        System.out.println(solution162.findPeakElement(nums));
    }
}
