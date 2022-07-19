package com.example.leetcode.codetop;

public class Solution712 {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = s2.charAt(j-1) + dp[0][j-1];
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = s1.charAt(i-1) + dp[i-1][0];
        }
        // 最重要的是找到状态是怎么转移的, 分情况讨论相等应该怎么转移,不相同怎么转移.
        for (int i = 1; i <= m; i++) {
            char charAt1 = s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char charAt2 = s2.charAt(j - 1);
                if (charAt2 == charAt1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //todo 这题主要转移错了
                    // 可以删除charAt1 这个 单词 ,也可以删除charAt2 这个单词
                    dp[i][j] =  Math.min(
                            dp[i][j - 1] + charAt2,
                            dp[i - 1][j] + charAt1);
                }
            }
        }
        return dp[m][n];
    }

//    public int minimumDeleteSum(String s1, String s2) {
//        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//
//        for (int i = s1.length() - 1; i >= 0; i--) {
//            dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i);
//        }
//        for (int j = s2.length() - 1; j >= 0; j--) {
//            dp[s1.length()][j] = dp[s1.length()][j+1] + s2.codePointAt(j);
//        }
//        for (int i = s1.length() - 1; i >= 0; i--) {
//            for (int j = s2.length() - 1; j >= 0; j--) {
//                if (s1.charAt(i) == s2.charAt(j)) {
//                    dp[i][j] = dp[i+1][j+1];
//                } else {
//                    dp[i][j] = Math.min(dp[i+1][j] + s1.codePointAt(i),
//                            dp[i][j+1] + s2.codePointAt(j));
//                }
//            }
//        }
//        return dp[0][0];
//    }

    public static void main(String[] args) {
        Solution712 solution712 = new Solution712();
        System.out.println(solution712.minimumDeleteSum("delete", "leet"));
    }
}
