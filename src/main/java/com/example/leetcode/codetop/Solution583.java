package com.example.leetcode.codetop;

public class Solution583 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 最重要的是找到状态是怎么转移的, 分情况讨论相等应该怎么转移,不相同怎么转移.
        for (int i = 1; i <= m; i++) {
            char charAt1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char charAt2 = word2.charAt(j - 1);
                if (charAt2 == charAt1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "etco";
        Solution583 solution583 = new Solution583();
        System.out.println(solution583.minDistance(word2, word1));

    }
}
