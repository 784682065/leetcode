package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 15:34
 */
public class Main2019 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (m == 0 && n == 0) {
                break;
            }

            int[] ints = new int[n + 1];
            int count = 0;
            for (int i = 0; i < n + 1; i++) {
                int nextInt = scanner.nextInt();
                if (m <= nextInt && count == 0) {
                    ints[i] = m;
                    i++;
                    ints[i] = nextInt;
                    count++;
                } else {
                    ints[i] = nextInt;
                }
            }

            for (int i = 0; i < ints.length; i++) {
                if (i < ints.length - 1) {
                    System.out.print(ints[i] + " ");
                } else{
                    System.out.print(ints[i] + "\r\n");
                }
            }
            }

        scanner.close();

    }
}
