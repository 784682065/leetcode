package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-26 11:22
 */
public class Solution547 {

    public static void main(String[] args) {
        int[][] M = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int circleNum = findCircleNum(M);
        System.out.println(circleNum);
    }

    public static int findCircleNum(int[][] M) {

        int n = M.length; //学生总数
        boolean[] b = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                count += dfs(M, i, b);
            }

        }

        return count;
    }

    private static int dfs(int[][] m, int i, boolean[] b) {
        b[i] = true;
        for (int j = 0; j < m[i].length; j++) {
            if (m[i][j] == 1 && !b[j]) {
                dfs(m, j, b);
            }
        }
        return 1;
    }
}
