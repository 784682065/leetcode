package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-24 8:41
 */
public class Solution121 {



    public int maxProfit(int[] prices) {

        int length = prices.length;
        if (length < 2) return 0;

//        int[] dp = new int[prices.length];

        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
