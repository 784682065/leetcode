package com.example.leetcode.solution;

import java.util.Arrays;

public class Solution64 {


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution64 solution64 = new Solution64();

        int res = solution64.minPathSum(grid);
        System.out.println(res);

    }


    public int minPathSum(int[][] grid) {

        int n1 = grid.length;
        int n2 = grid[0].length;
//        int n1 = 10, n2 = 10;
        int[][] arr = new int[n1][n2];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                // 初始化
                if (i == 0 && j == 0) {
                    arr[i][j] = grid[i][j];
                    continue;
                }

                if (i == 0) {
                    arr[i][j] = arr[i][j - 1] + grid[i][j];
                }

                if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + grid[i][j];
                }

                if (i != 0 && j != 0) {
                    // 状态转移
                    arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]) + grid[i][j];
                }

            }
        }


        return arr[n1 - 1][n2 - 1];
    }

}
