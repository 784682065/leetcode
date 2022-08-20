package com.example.leetcode.codetop;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int ans = strs[0].length();
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int minLen = Math.min(cur.length(), pre.length());
            minLen = Math.min(minLen, ans);
            ans = minLen;
            for (int j = 0; j < minLen; j++) {
                if (pre.charAt(j) != cur.charAt(j)) {
                    ans = j;
                    break;
                }
            }
        }
        return strs[0].substring(0, ans);
    }

    public static void main(String[] args) {

        String[] strs = {"ab","a"};
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
