package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 16:36
 */
public class Main2029 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        for (int k = 0; k < nextInt; k++) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            int length = chars.length;
            boolean flag = true;
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[length - i - 1]) {
                    System.out.println("no");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            }
        }

    }
}
