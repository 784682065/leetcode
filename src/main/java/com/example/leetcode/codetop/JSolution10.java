package com.example.leetcode.codetop;

public class JSolution10 {

    public int numWays(int n) {
        if (n == 0)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] % 1000000007;
        }
        return dp[n] ;
    }
}
