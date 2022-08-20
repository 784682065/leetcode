package com.example.leetcode.solution;

public class NumArray {

    private int[] nums;
    private int[] preSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        return left ==0 ? preSum[right] : preSum[right] - preSum[left - 1];
    }

    public static void main(String[] args) {

        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // return 1 ((-2) + 0 + 3)
        System.out.println(numArray.sumRange(2, 5)); // return -1 (3 + (-5) + 2 + (-1))
        System.out.println(numArray.sumRange(0, 5)); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))


    }
}
