package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 10:04
 */
public class Main2081 {

    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        if (n == 0) System.out.println(0);

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            System.out.println("6" + s.substring(6, s.length()));
        }

        scanner.close();
    }
}
