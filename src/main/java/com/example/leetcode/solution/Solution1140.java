package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-26 16:34
 */
public class Solution1140 {

    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0)
            return 0;
        int n = piles.length;
        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i]; //suffixSum[i] 表示从i -- size 的全部石碓的和
        }
        dp = new int[n][n];
        return findMaxStones(piles, 0, 1);
    }

    private int[] suffixSum;
    private int[][] dp;

    private int findMaxStones(int[] piles, int i, int M) {
        if (i == piles.length)
            return 0;
        if (i + 2 * M >= piles.length) { //如果可以一把抓走所有的 就拿走所有的
            return suffixSum[i];
        }
        if (dp[i][M] != 0)
            return dp[i][M];
        int minStones = Integer.MAX_VALUE;
        for (int X = 1; X <= 2 * M; X++) {
            minStones = Math.min(minStones, findMaxStones(piles, i + X, Math.max(X, M)));   //找出对手可以获得的最小石子数
        }
        dp[i][M] = suffixSum[i] - minStones;
        return dp[i][M];
    }

}
