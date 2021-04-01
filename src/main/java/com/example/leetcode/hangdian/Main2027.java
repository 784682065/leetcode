package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 14:39
 */
public class Main2027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            int an = 0, en = 0, in = 0, on = 0, un = 0;
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == 'a') {
                    an++;
                }
                if (aChar == 'e') {
                    en++;
                }
                if (aChar == 'i') {
                    in++;
                }
                if (aChar == 'o') {
                    on++;
                }
                if (aChar == 'u') {
                    un++;
                }
            }
            System.out.println("a:" + an);
            System.out.println("e:" + en);
            System.out.println("i:" + in);
            System.out.println("o:" + on);
            System.out.println("u:" + un);
            if (i != n - 1) {
                System.out.println();
            }
        }


    }
}
