package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution209 {

    public int minSubArrayLen(int target, int[] nums) {

        // 前缀和.

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        if (preSum[nums.length - 1] < target) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        // 用二分查找优化
        for (int i = -1; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (i == -1) {
                    if (preSum[j] == target) {
                        ans = Math.min(ans, j - i);
                    }
                    continue;
                }
                if (preSum[j] - preSum[i] == target) {
                    ans = Math.min(ans, j - i);
                } else if (preSum[j] - preSum[i] < target) {
                    break;
                }
            }

        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public int minSubArrayLenOF(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public int minSubArrayLenDoublePtr(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }



    public static void main(String[] args) {

//        11
//                [1,2,3,4,5]
        int target = 11;
//        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums = {1,2,3,4,5};
        Solution209 solution209 = new Solution209();
        System.out.println(solution209.minSubArrayLenOF(target, nums));
    }
}
