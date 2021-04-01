package com.example.leetcode.hangdian;

import com.sun.javafx.binding.StringFormatter;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  16:29 2020/4/18
 * @param:
 */
public class Main2048 {
    // f(n)=(n-1)*（f(n-1)+f(n-2)）.
    public static void main(String[] args) {

        long[] a = new long[21];
        a[1] = 0;
        a[0] = 0;
        a[2] = 1;
        for (int i = 3; i < 21; i++) {
            a[i] = (i - 1) * (a[i - 2] + a[i - 1]);
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            long r = 1;
            for (int j = 1; j <= m; j++) {
                r = r * j;
            }

            double t = 1.0 * ((double) a[m] / r) * 100;
            System.out.printf("%.2f%%", t);
            System.out.println();
        }


    }
}
