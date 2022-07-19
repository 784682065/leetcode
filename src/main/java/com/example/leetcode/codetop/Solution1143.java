package com.example.leetcode.codetop;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            char charAt1 = text1.charAt(i);
            for (int j = 0; j < text2.length(); j++) {
                int row = i + 1;
                int clo = j + 1;

                // 状态转移 没弄清楚,
                // 相同的时候, 由他们两个除去本身之外的字符串转移而来
                // 不相同的时候又 各自出去自己中大的而来
                char charAt2 = text2.charAt(j);
                if ( charAt1 == charAt2 ){
                    dp[row][clo] = ++dp[row - 1][clo - 1];
                }else {
                    dp[row][clo]  =  Math.max(dp[row - 1][clo],dp[row][clo - 1]);
                }
            }
        }
        return dp[text1.length()] [text2.length()];
    }

    public static void main(String[] args) {
        String t1 = "abccc" , t2 = "ace";
        Solution1143 solution1143 = new Solution1143();
        int i = solution1143.longestCommonSubsequence(t1, t2);
        System.out.println(i);
    }
}
