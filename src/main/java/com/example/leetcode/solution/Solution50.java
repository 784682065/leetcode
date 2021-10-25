package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2021/10/18
 * @description:
 */
public class Solution50 {

    public double myPow(double x, int n) {

        return n >= 0 ? quickMul1(x, n) : 1.0 / quickMul1(x, -n);

    }

    public double quickMul(double x, long n) {
        if (n == 0) return 1;

        double res1 = quickMul(x, n / 2);
        if (n % 2 == 0) {
            return res1 * res1;
        } else {
            return res1 * res1 * x;
        }
    }

    public double quickMul1(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }



    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double v = solution50.myPow(2, 10);
        System.out.println(v);
    }

}
