package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * @Author: huzp
 * @Description: 最大子序和
 * @Date: Created in  16:02 2020/4/9
 * @param:
 */
class Solution53 {

    /**
     * 大部分测试用例解决,但是最后计算超时
     */
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE, sumval;
        for (int r = nums.length - 1; r >= 0; r--) {
            for (int l = 0; l <= r; l++) {
                sumval = Arrays.stream(Arrays.copyOfRange(nums, l, r + 1))
                        .reduce(0, (x, y) -> x + y);

                max = Math.max(max, sumval);
            }
        }
        return max;
    }


    public static int maxSubArrayDividConquer(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }

    private static int helper(int[] nums, int l, int r) {
        if (l > r) return Integer.MIN_VALUE;
        int mid = (l + r) >>> 1;
        int left = helper(nums, l, mid - 1);
        int right = helper(nums, mid + 1, r);
        int leftMaxSum = 0;
        int sum = 0;
        // left surfix maxSum start from index mid - 1 to l
        for (int i = mid - 1; i >= l; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }
        int rightMaxSum = 0;
        sum = 0;
        // right prefix maxSum start from index mid + 1 to r
        for (int i = mid + 1; i <= r; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(sum, rightMaxSum);
        }
        // max(left, right, crossSum)
        return Math.max(leftMaxSum + rightMaxSum + nums[mid], Math.max(left, right));
    }


    public static int sum(int i, int[] nums) {
        int sum = 0;
        for (int i1 = 0; i1 < i; i1++) {
            sum = sum + nums[i1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1,1};
        int i = maxSubArrayDividConquer(nums);
        System.out.println(i);
    }
}
