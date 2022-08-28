package com.example.leetcode.codetop;

public class Solution283 {

    public void moveZeroes(int[] nums) {
        int zeroIdx = -1;
        // 找第一个0的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }
        if (zeroIdx == -1)
            return;
        for (int i = zeroIdx + 1; i < nums.length; i++) {
            if (nums[i] !=0) {
                swap(nums, i, zeroIdx++);
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
    }
}
