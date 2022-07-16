package com.example.leetcode.codetop;

import java.util.*;

public class Solution31 {

    public void nextPermutation(int[] nums) {

        // 从后往前, 找到不上升序列的第一个数,后面的上升序列找到第一个大于他的数,交换
        // 之后 后面的数降序排列

        int pre = -1;
        int index = nums.length - 1;

        while (index >=0 && nums[index] >= pre) {
            pre = nums[index];
            index--;
        }

        if (index >= 0) {
            // 从末尾找一个大于他的数
            int j = nums.length - 1;
            for (; j >= index; j--) {
                if (nums[j] > nums[index]) {
                    // 交换
                    swap(nums,index,j);
                    break;
                }
            }
        }

        reverse( nums,index+1);
    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};

        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
