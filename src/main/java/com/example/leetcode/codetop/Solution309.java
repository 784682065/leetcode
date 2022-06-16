package com.example.leetcode.codetop;

public class Solution309 {

    public int maxProfit(int[] prices) {


        if (prices.length < 2)
            return 0;

        //一定要理解状态方程
        //我们用 f[i] 表示第 ii 天结束之后的「累计最大收益」
        int[][] f = new int[prices.length][3];
        //我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
        //我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]；
        //我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。

        f[0][0] = -prices[0];
        f[0][1] = 0;
        f[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 持有股票, 转移而来的状态有: 昨天持有股票, 昨天不处于冷冻期今天买入
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);

            // 目前不持有任何股票，并且处于冷冻期中  由 昨天卖出股票而来

            f[i][1] = f[i - 1][0] + prices[i];

            // 目前不持有任何股票，并且不处于冷冻期中 状态由
            // 1. 昨天冷冻期转移而来 2. 昨天不持有任何股票，并且不处于冷冻期中 3, 昨天持有股票 今天卖出
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);

        }

        return Math.max(f[prices.length - 1][2], f[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        Solution309 solution309 = new Solution309();
        int i = solution309.maxProfit(prices);
        System.out.println(i);
    }

}
