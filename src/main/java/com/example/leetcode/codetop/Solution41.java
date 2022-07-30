package com.example.leetcode.codetop;

import java.util.concurrent.Executors;

public class Solution41 {

    public int firstMissingPositive(int[] nums) {
//        Executors.newSingleThreadExecutor();

        int length = nums.length;
        int cur;
        //todo 采用 0 1 -1 标记法,会扰乱原先的值, 应该像官方一样将原先的值都变成正值,
        // 负数变成length+1 , 后把每个值对应的下表标记为负数,最后找第一个正数的值
        //todo 我的方法跟接近方法2 , 置换法,应该采用置换的要求,把值换到对应位置.
        for (int i = 0; i < length; i++) {
            int n = nums[i];
            while (n > 0 && n <= length) {
                cur = nums[n - 1];
                nums[n - 1] = cur;
                if (cur == n) {
                    break;
                }
                nums[i] = cur;
                n = cur;
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                return i + 1;
            }
        }

        return length+1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        Solution41 solution41 = new Solution41();
        int i = solution41.firstMissingPositive(nums);
        System.out.println(i);
    }
}
