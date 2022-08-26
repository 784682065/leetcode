package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }

        int ans = 0;
        for (Integer num : set) {
            int curAns = 1;
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(num+1)) {
                ++curAns;
                ++num;
            }
            ans = Math.max(ans, curAns);
        }


//        for (int i = 0; i < nums.length; i++) {
//            int cur = nums[i];
//            int tempTimes = 1;
//            int tempNum = cur + 1;
//            while (set.contains(tempNum)) {
//                ++tempTimes;
//                ++tempNum;
//            }
//            ans = Math.max(ans,tempTimes);
//        }
        return ans;
    }

    public static void main(String[] args) {

        Solution128 solution128 = new Solution128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution128.longestConsecutive(nums));

    }
}
