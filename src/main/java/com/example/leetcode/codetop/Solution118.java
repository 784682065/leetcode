package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        int j = 1;
        for (int i = 0; i < j; i++) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < j; k++) {
                if (k - 1 < 0 || k == (j -1)){
                    dp[i][k] =1;
                    list.add(dp[i][k]);
                }else {
                    dp[i][k] = dp[i-1][k-1] + dp[i-1][k];
                    list.add(dp[i][k]);
                }
            }
            res.add(list);

            ++j;
            if (j > numRows)
                break;
        }
        return res;

    }

    public static void main(String[] args) {

        Solution118 solution118 = new Solution118();

        solution118.generate(5);
    }
}
