package com.example.leetcode.solution;

public class Solution70 {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 0; i <= n; i++) {
            if (i + 1 <= n)
                res[i + 1] += res[i] ;
            if (i + 2 <= n)
                res[i + 2] += res[i];
        }
        return res[n];
    }

}
