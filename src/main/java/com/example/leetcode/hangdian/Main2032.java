package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description: 杨辉三角
 * @Date: Created in  8:53 2020/4/18
 * @param:
 */
public class Main2032 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j > i) {
                        a[i][j] = 0;
                        continue;
                    }
                    if (j == 0 || j == i) {
                        a[i][j] = 1;
                        continue;
                    }
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] != 0) {
                        if (j == i) {
                            System.out.print(a[i][j]);
                        } else {
                            System.out.print(a[i][j] + " ");
                        }
                    }

                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
