package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 14:33
 */
public class Main2017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            //next 是个坑
            strings[i] = scanner.next();

            for (char c : strings[i].toCharArray()) {
                if (Character.isDigit(c)) {
                    count[i]++;
                }
            }
        }
        for (int j : count) {
            System.out.println(j);
        }
    }
}
