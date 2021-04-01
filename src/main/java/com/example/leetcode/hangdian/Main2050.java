package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  17:23 2020/4/18
 * @param:
 */
public class Main2050 {

    static long[] a = new long[10001];
    static {
        a[0] = 1;
        a[1] = 2;
        a[2] = 7;
        for (int i = 3; i < a.length; i++) {
            a[i] = a[i - 1] + 4 * (i - 1) + 1;
        }
    }

    //f(n) = f(n -1) + 4 *(n-1) +1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int x = scanner.nextInt();
            System.out.println(a[x]);
        }

    }
}
