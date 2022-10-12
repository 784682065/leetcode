package com.example.leetcode.codetop;

import java.text.DecimalFormat;

/**
 * @author: huzepeng
 * @date: 2022/10/11
 * @desc:
 */
public class Solution50 {
    public double myPow(double x, int n) {

//        DecimalFormat df = new DecimalFormat("0.00000");
        if (n == 0)
            return 1;

        int times = Math.abs(n);

        double res= 1;
        for (int i = 0; i < times; i++) {
            res *= x;
        }

        return  n > 0 ? res : 1/res;
    }


    // 每次把N 除以 2 ,用幂的结果乘以幂
    public double myPowOFFICAL(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();

        System.out.println(solution50.myPow(2.000, -2));


    }
}
