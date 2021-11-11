package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2021/11/10
 * @description:
 */
public class Solution31 {

    public void offical_nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //while 循环判断是否降序
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //若是i >=0 说明全序列不是降序
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换从 后往前数第一个大于不是降序的值 和 不是降序的值
            swap(nums, i, j);
        }
        // 翻转降序序列
        reverse(nums, i + 1);
    }


    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) return;
        // 如果不是最大序列的话,那就 从后一个一个往前比, 先把大的换到前面,
        // 换了一个大的以后,把换的位置后面的所有数字从升序排列
        int change = -1; //change 后面的数按照顺序排列
        int ori = -1; //change 后面的数按照顺序排列
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i <= change) {
                swap(nums,ori,change);
            }
            int end = 0;
            if (change != -1) {
                end = change;
            }
            for (int j = i; j >= end; j--) {
                if (nums[i] > nums[j]) {
                    if (change < j) {
                        ori = i;
                        change = j;
                        break;
                    }
                }
            }
        }
        if (change != -1) {
            // 需要升序排列 change 后面的所有数字
            for (int i = change + 1; i < nums.length; i++) {
                int min = nums[i];
                int minPos = -1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (min > nums[j]) {
                        min = nums[j];
                        minPos = j;
                    }
                }
                if (minPos != -1) {
                    swap(nums,i,minPos);
                }
            }
        } else {
            reverse(nums,0);
        }
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
        int[] nums = {0, 0, 4, 2, 1, 0};
        Solution31 solution31 = new Solution31();
        solution31.nextPermutation(nums);
        for (int i :
                nums) {
            System.out.println(i);
        }
    }
}
