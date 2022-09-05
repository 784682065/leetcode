package com.example.leetcode.codetop;

public class Solution912_qs {

    // 快排
    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left <= right) {
            // 找出某个值的位置,返回位置,继续做
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos-1);
            quickSort(nums, pos+1, right);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int ptr = left, x = nums[right];
        // 把最后一个x换到他应该在的位置
        for (int i = left; i <= right; i++) {
            if (x > nums[i]) {
                // 换i与ptr 保证ptr左边都是比x小的值
                swap(nums, ptr, i);
                ptr++;
            }
        }
        // 换到应该换的位置
        swap(nums, ptr, right);
        return ptr;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
