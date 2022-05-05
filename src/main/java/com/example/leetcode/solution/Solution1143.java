package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/5/3
 * @description: 公共子序列, 动态规划
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j-1]);
                }

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String t1 = "bdcaba";
        String t2 = "abcdda";
        Solution1143 solution1143 = new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence(t1, t2));
    }
}
