package com.example.leetcode.codetop;

public class Solution72 {

    public int minDistance(String word1, String word2) {

        if (word1.length() * word2.length() == 0) {
            return word1.length() + word2.length();
        }
        // 必须要初始化边界, 不然 在 word1的第二个位置和word2 的第一个位置,就只能继承 ,而不能使用删除一个的办法

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                char charAt1 = word1.charAt(i -1);
                char charAt2 = word2.charAt(j -1);

                int top = dp[i - 1][j];
                int left = dp[i][j - 1];
                int leftTop = dp[i-1][j - 1];

                dp[i][j] = Math.min(top +1, left +1);
                if (charAt1 == charAt2) {
                    dp[i][j] = Math.min(dp[i][j], leftTop);
                } else {
                    dp[i][j] = Math.min(dp[i][j], leftTop + 1);
                }

            }
        }
        return dp[word1.length() ][word2.length() ];
    }

    public static void main(String[] args) {
        Solution72 solution72 = new Solution72();
        int i = solution72.minDistance("sea", "eat");
        System.out.println(i);
    }
}
