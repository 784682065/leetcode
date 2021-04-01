package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  21:34 2020/4/15
 * @param:
 */
public class Main2011 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int[] ints = new int[m];
        for (int i = 0; i < m; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i1 = 0; i1 < ints.length; i1++) {
            double sum = 0;
            for (double j = 1; j <= ints[i1]; j++) {
                if (j % 2 != 0) {
                    sum = sum + (1 / j);
                } else {
                    sum = sum - (1 / j);
                }
            }
            System.out.printf("%.2f\r\n", sum);
        }

    }
}
