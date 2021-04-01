package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 15:07
 */
public class Main2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int[] ints = new int[56];
            for (int i = 0; i < 56; i++) {
                if (i <= 3) {
                    ints[i] = i;
                } else {
                   ints[i] = ints[i-3] + ints[i -1];
                }
            }
            System.out.println(ints[n]);
        }
        scanner.close();
    }
}
