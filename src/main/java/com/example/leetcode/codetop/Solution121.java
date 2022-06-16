package com.example.leetcode.codetop;

public class Solution121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }

    public int maxProfit_DP(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {

        int[] arr = {7,1,5,3,6,4};
        Solution121 solution121 = new Solution121();
        solution121.maxProfit_DP(arr);
    }

}
