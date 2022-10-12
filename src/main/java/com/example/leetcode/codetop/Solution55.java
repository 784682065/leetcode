package com.example.leetcode.codetop;

/**
 * @author: huzepeng
 * @date: 2022/10/9
 * @desc:
 */
public class Solution55 {

    // 每次找最大的跳
    public boolean canJump(int[] nums) {

        int len = nums.length;
        int maxVal = nums[0];
        int maxIndex = 0;
        for (int i = maxIndex; i < len; ) {
            if (maxVal + 1 >= len) {
                return true;
            }
            if (nums[maxIndex]  == 0)
                return false;
            int j;
            for (j = i + 1; j <= i + nums[i]; j++) {
                if (j + nums[j] >= maxVal) {
                    maxVal = j + nums[j];
                    maxIndex = j;
                }
            }

            i = maxIndex;
        }
        return maxVal + 1 >= len;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(nums));
    }
}
