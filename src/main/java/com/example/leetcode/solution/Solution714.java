package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-24 9:26
 */
public class Solution714 {


    public static void main(String[] args) {

        int[] prices = {1, 3, 2, 8, 4, 9};

        maxProfit(prices,2);
    }


    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益'
        // j = 0 表示不持股，j = 1 表示持股
        // 并且规定在买入股票的时候，扣除手续费
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);  //卖出股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee); //现金购买股票
        }
        return dp[len - 1][0];
    }

}
