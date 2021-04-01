package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 11:08
 */
public class Main2014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n < 2 ) {
                continue;
            }
            int[] ints = new int[n];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
                if (ints[i] < min) min = ints[i];
                if (ints[i] > max) max = ints[i];
                sum = sum + ints[i];
            }
            System.out.printf("%.2f\r\n", (double)(sum -max -min)/(n-2));
        }
    }
}
