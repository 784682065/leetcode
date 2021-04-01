package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 9:52
 */
public class Main2091 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        while (in.hasNext()) {
            char c = in.next().charAt(0);
            if (c == '@') {
                break;
            }
            int n = in.nextInt();
            sum++;
            if (sum != 1) {
                System.out.println();
            }
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    for (int j = 0; j < 2 * n - 1; j++) {
                        System.out.print(c);
                    }
                    System.out.println();
                } else if (i == 0) {
                    for (int j = 0; j < n - 1 ; j++) {
                        System.out.print(" ");
                    }
                    System.out.println(c);
                } else {
                    for (int j = 0; j < n - 1 - i; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(c);
                    for (int j = 0; j < 2 * i - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.println(c);
                }
            }
        }
    }

}
