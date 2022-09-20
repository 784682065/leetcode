package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // 因为下面是min ,所以上面要大的值,但是Max_Value又不行,因为下面加dp[i - coin] + 1 会溢出
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] >  amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int i = solution322.coinChange(coins, amount);
        System.out.println(i);

    }
}
