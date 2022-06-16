package com.example.leetcode.codetop;

public class Solution714 {


    public int maxProfit(int[] prices, int fee) {

        if (prices.length < 2 )
            return 0;

        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            // 现金 由昨天的现金或者今天卖出股票而来
            cash = Math.max(cash, hold + prices[i] - fee);
            // 持有股由 昨天持有股, 或者今天持有股
            hold = Math.max(hold, cash - prices[i]);

        }
        return cash;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        Solution714 solution714 = new Solution714();
        int i = solution714.maxProfit(prices, fee);
        System.out.println(i);
    }

}
