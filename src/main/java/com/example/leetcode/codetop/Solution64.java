package com.example.leetcode.codetop;

public class Solution64 {


    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                // 拿到上左的值
                int top = Integer.MAX_VALUE;
                int left = Integer.MIN_VALUE;
                if (i > 0) {
                    top = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = grid[i][j] + Math.min(left, top);
            }
        }


        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        Solution64 solution64 = new Solution64();
        System.out.println(solution64.minPathSum(grid));

    }
}
