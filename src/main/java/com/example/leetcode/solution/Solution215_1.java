package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * @author: hzp
 * @date: 2022/3/21
 * @description:
 */
public class Solution215_1 {



    /**
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        int right = nums.length -1;
        int left = 0;
        while (true){
            int sort = sort(nums, left, right);
            if (sort == (k-1)){
                return nums[sort];
            } else if (sort < (k-1)){
                left = sort +1;
            }else {
                right = sort - 1;
            }
        }
    }


    public static int sort(int[] nums, int left, int right) {
        if (left >= right)
            return left;

        // 1. left 值作为基准值
        int q = nums[left];
        // 初始位置是自己 ,如果加1 的话在顺序已经是拍好的情况下,
        // 会导致i==j的值提前一位,导致交换错误
        int i = left;
        int j = right;
        //从右往左开始换
        while (i < j) {
            while (j > i && nums[j] <= q) {
                j--;
            }
            while (j > i && q <= nums[i]) {
                i++;
            }
            // 不相等换位置
            if (i != j) {
                int val = nums[j];
                nums[j] = nums[i];
                nums[i] = val;
            }
        }
        // 出了循环肯定是i ==j

        nums[left] = nums[i];
        nums[i] = q;

        return i;
    }


    public static void main(String[] args) {
        int[] a = {-1,2,0};
        Solution215_1 solution215_1 = new Solution215_1();
        int kthLargest = solution215_1.findKthLargest(a, 1);
        System.out.println(kthLargest);

    }
}
