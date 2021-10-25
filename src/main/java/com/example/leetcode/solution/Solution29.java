package com.example.leetcode.solution;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author: hzp
 * @date: 2021/10/19
 * @description:
 */
public class Solution29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long a = dividend;
        long b = divisor;
        boolean sign = true;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = false;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = div(a, b);

        return (int) (sign ? res : -res);

    }

    public int div(long a, long b) {
        if (a < b) return 0;
        long count = 1;
        long tb = b; // 在后面的代码中不更新b
        while ((tb + tb) <= a) {
            count = count + count; // 最小解翻倍
            tb = tb + tb; // 当前测试的值也翻倍
        }
        return (int) (count + div(a - tb, b));
    }


    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int res = solution29.divide(-2147483648, -1);
        System.out.println(res);
    }
}
