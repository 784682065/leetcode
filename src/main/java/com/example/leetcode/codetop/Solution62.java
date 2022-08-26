package com.example.leetcode.codetop;

import java.util.*;

public class Solution62 {

    static int res;

    static int[][] dir = {{1,0},{0,1}};
    public int uniquePaths(int m, int n) {

        res = 1;

//        int[] startPos = {0,0};
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(startPos);
//        while (!queue.isEmpty()){
//            int[] poll = queue.poll();
//            if (poll[0] == (m-1) && poll[1] == (n-1)){
//                // 走到终点
//                continue;
//            }
//            int count = -1;
//            for (int[] ints : dir) {
//                int idxX = poll[0] + ints[0];
//                int idxY = poll[1] + ints[1];
//                if (idxX < m && idxY<n){
//                    ++count;
//                    queue.offer(new int[]{idxX,idxY});
//                }
//            }
//            res +=count;
//        }
        // 初始化
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] =1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] =1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        Solution62 solution62 = new Solution62();
        System.out.println(solution62.uniquePaths(6, 1));


    }
}
