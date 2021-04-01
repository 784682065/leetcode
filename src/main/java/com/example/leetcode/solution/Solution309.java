package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-24 10:14
 */
public class Solution309 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        // dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益'
        // j = 0 表示不持股，j = 1 表示持股 , 2 代表 不持股处于冷冻期
        // 并且规定在买入股票的时候，扣除手续费
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {

            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]); //第一天的时候 前天不持股值 设为0 ,因为不存在-1 天.
                continue;
            }

            //不持股状态,状态可以由前一天持股卖出今天股票 或者昨天不持股而来
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持股状态, 可以由 昨天继承股票 或者 前天不持有今天买入而来 , 不可以由昨天不持股而来, 因为昨天不持股可能是因为昨天刚刚卖出了股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

        }
        return dp[len - 1][0];
    }
}
