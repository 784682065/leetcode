package com.example.leetcode.hangdian;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 15:06
 */
public class Main2028 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(new BufferedInputStream(System.in));
        int n;
        long u = 1, v ;
        while (s.hasNext()) {
            n = s.nextInt();
            for (int i = 0; i < n; ++i) {
                if (i == 0) {
                    u = s.nextInt();
                    v = u;
                } else {
                    v = s.nextInt();
                    try {
                        u = lcm1(u, v);
                    } catch (ArithmeticException e) {
                        e.printStackTrace();
                    }

                }

            }
            System.out.println(u);
        }
    }

    static long lcm1(long u, long v) {
        //u *v /最大公约数
        return (u * v) / gcd1(u, v);
    }

    //最大公约数
    //欧几里得辗转相除法
    private static long gcd1(long u, long v) {
        long result = v;
        //一定要余数为0
        while (u % v != 0) {
            result = u % v;
            u = v;
            v = result;
        }
        return result;
    }
}
