package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  14:57 2020/4/19
 * @param:
 */
public class Main2065 {

    /**
     *  https://blog.csdn.net/KingsCC/article/details/81414370
     * ：f[n][0] = 2^(2*n - 2) + 2^(n - 1)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int t = scanner.nextInt();
            if (t == 0) break;
            int i = 1;
            while (t-- > 0) {
                long N = scanner.nextLong();
                int ans = (pow(4, N - 1) + pow(2, N - 1)) % 100;
                System.out.printf("Case %d: %d", i++, ans);
                System.out.println();
            }
            System.out.println();
        }

    }


    static int pow(int a, long n) {
        if (n == 0)
            return 1;
        int res = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = (res * a) % 100;
            }
            a *= a;
            a %= 100;
            n >>= 1;//右移一位比直接除二更高效
        }
        return res;

    }

}
