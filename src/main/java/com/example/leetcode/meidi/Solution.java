package com.example.leetcode.meidi;

public class Solution {

    public double maxProfit (double[] prices) {

        // write code here
        double max = 0;
        double hold = prices[0];

        for (double price : prices) {
            if (hold > price){
                hold = price;
            }
            if (price > hold){
                max = Math.max(max,price- hold);
            }
        }
        return max;
    }
}
