package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:51 2020/4/18
 * @param:
 */
public class Main2035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            if (b == 0) {
                System.out.println(1);
                continue;
            }
            a %= 1000;
            int r = 1;
            for (int i = 0; i < b; ++i) {
                r = r * a % 1000;
            }
            System.out.println(r);
        }
    }
}
