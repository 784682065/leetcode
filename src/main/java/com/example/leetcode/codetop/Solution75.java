package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.Random;

public class Solution75 {


    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partial(nums, left, right);
            quickSort(nums, left, pos);
            quickSort(nums, pos + 1, right);

        }

    }

    private int partial(int[] nums, int left, int right) {

        Random random = new Random();
        int ptr = left, pvt = random.nextInt(right - left + 1) + left;
        swap(nums, pvt, right);

        for (int i = left; i < right; i++) {
            if (nums[right] > nums[i]){
                swap(nums,i,ptr);
                ptr++;
            }
        }
        swap(nums,right,ptr);
        return ptr;
    }

    private void swap(int[] nums, int pvt, int right) {
        int temp = nums[pvt];
        nums[pvt] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution75 solution75 = new Solution75();
        solution75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


}
