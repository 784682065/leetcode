package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:58 2020/4/18
 * @param:
 */
public class Main2060 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int sum = 0;
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                if (a >= 6) {
                    b =b+ (a - 6) * 8 + 27;
                } else {
                    b =b+ (7+ (8 - a)) * a / 2; //等差数列和
                }
                if (b >= c) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
