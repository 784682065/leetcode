package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 16:07
 */
public class Main2077 {

    static private int N = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            N = k;
            long res = hanno(k);
            System.out.println(res);
        }
        scanner.close();

    }

    private static long hanno(int k) {

        if (k == 1) return 2;
        else if (k == N)
            return hanno(k - 1) + 2;
        else {
            return 3 * hanno(k - 1) + 2;
        }
    }
}
