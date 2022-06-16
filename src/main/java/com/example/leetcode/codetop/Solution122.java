package com.example.leetcode.codetop;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态数组
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int[] cash = new int[len];
        int[] hold = new int[len];

        // 主要是把cash 滚大
        cash[0] = 0;
        hold[0] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            // 与121 只能买卖一次不同 这里hold 状态转移是现金减去价格 cash[i - 1] - prices[i]
            // 一次买卖是直接 - prices[i],认为现金为0
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
        }
        return cash[len - 1];
    }

}
