package com.example.leetcode.codetop;

public class Solution221 {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        int ans =  0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char mat = matrix[i][j];
                if (mat == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    ans = Math.max(ans,dp[i][j]);
                    continue;
                }
                int left = dp[i][j - 1];
                int top = dp[i - 1][j];
                int lt = dp[i - 1][j - 1];
                int min = Math.min(lt, Math.min(left, top));
                dp[i][j] = min + 1;
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','1','1'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};

        Solution221 solution221 = new Solution221();
        System.out.println(solution221.maximalSquare(matrix));

    }
}
