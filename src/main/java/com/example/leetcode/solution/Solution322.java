package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-24 13:54
 */
public class Solution322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};

        System.out.println(coinChange(coins, 11));
    }

    public static int coinChange(int[] coins, int amount) {

        int length = coins.length;
        if (length == 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < length; i++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }


        return dp[amount] > amount ? -1 : dp[amount];
    }
}
