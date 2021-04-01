package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-24 14:35
 */
public class Solution474 {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));

    }

    private static int[] calcZeroAndOne(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String s : strs) {
            int[] ints = calcZeroAndOne(s);
            int zeroInt = ints[0];
            int oneInt = ints[1];
            for (int i = m; i >= zeroInt; i--) {
                for (int j = n; j >= oneInt; j--) {
                    //状态转移方程 d[i][j] 使用i个0 和j 个1 只有两种可能
                    //1. 原先就使用了这么多,这个不选
                    //2. 这次选了,才使用了i个0和j 个1
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroInt][j - oneInt] + 1);
                }
            }

        }


        return dp[m][n];
    }


}
