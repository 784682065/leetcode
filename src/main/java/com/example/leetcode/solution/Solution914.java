package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * @author: hzp
 * @date: 2022/3/22
 * @description:
 */
public class Solution914 {

    public int[] sortArray(int[] nums) {


        quickSort(nums, 0, nums.length - 1);

        return nums;
    }


    private void quickSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int base = nums[left];
        int i = left, j = right;

        // 比基准值大的放左边
        // 比基准值小的放右边
        while (i < j) {
            // 从右边开始比
            while (i < j && nums[j] >= base) {
                --j;
            }
            while (i < j && nums[i] <= base) {
                ++i;
            }

            if (i !=j ){
                // 交换i 与 j的值
                int val = nums[j];
                nums[j] = nums[i];
                nums[i] = val;
            }
        }

        // 交换中间枢纽值和 base
        nums[left] = nums[j];
        nums[j] = base;

        quickSort(nums, left, j-1);
        quickSort(nums, j+1, right);

    }

    public static void main(String[] args) {
        Solution914 solution914 = new Solution914();
        int[] nums = {5,2,3,1};
        int[] ints = solution914.sortArray(nums);
        System.out.println(Arrays.toString(ints));

    }
}
