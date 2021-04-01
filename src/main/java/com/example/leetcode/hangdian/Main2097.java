package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 15:19
 */
public class Main2097 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            if (n == 0) break;
            int s1 = f(n, 10), s2 = f(n, 12), s3 = f(n, 16);
            if (s1 == s2 && s2 == s3)
                System.out.println(n + " is a Sky Number.");
            else
                System.out.println(n + " is not a Sky Number.");
        }
    }

    public static int f(int n, int i) {
        int s = 0;
        while (n != 0) {
            s += n % i;
            n /= i;
        }
        return s;
    }
}
