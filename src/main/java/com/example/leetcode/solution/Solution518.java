package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-24 15:17
 */
public class Solution518 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 5};
        int change = change(11, ints);
        System.out.println(change);
    }

    public static int change(int amount, int[] coins) {

        if (amount == 0 || (coins.length == 0 && amount > 0)) return 0;

        int[] dp = new int[amount + 1];

        dp[0] = 1; //金额为0 也有一种方案就是 不给钱.
        for (int j = amount; j >= 0; j--) {
            for (int i = 0; i < coins.length; i++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public int chang1(int amount, int[] coins) {
        int K = coins.length + 1; //使用硬币数
        int I = amount + 1;  //金额数
        int[][] DP = new int[K][I];
        //初始化数组
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < I; i++) {
                DP[k][i] = 0;
            }
        }
        //初始化基本状态
        for (int k = 0; k < coins.length + 1; k++) {
            DP[k][0] = 1;
        }
        for (int k = 1; k <= coins.length; k++) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coins[k - 1]) {
                    DP[k][i] = DP[k][i - coins[k - 1]] + DP[k - 1][i];
                } else {
                    DP[k][i] = DP[k - 1][i];
                }
            }
        }
        return DP[coins.length][amount];
    }
}
