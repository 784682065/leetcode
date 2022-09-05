package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : ss) {
            stringBuilder.append(s);
        }
        // 取出前导0
        String res = stringBuilder.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }


    public static void main(String[] args) {
        int[] nums = {10,2};
        Solution179 solution179  = new Solution179();
        System.out.println(solution179.largestNumber(nums));
    }
}
