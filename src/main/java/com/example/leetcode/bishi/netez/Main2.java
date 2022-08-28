package com.example.leetcode.bishi.netez;

import java.util.Scanner;

//70
public class Main2 {

    static int times;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        times = Integer.MAX_VALUE;
        cal(s[0], s[1], 0);
        System.out.println(times == Integer.MAX_VALUE ? -1 : times);

    }

    private static void cal(String a, String b, int count) {
        // 不可能
        if (a.isEmpty() || b.isEmpty() || count >= times)
            return;

        int an = Integer.parseInt(a);
        int bn = Integer.parseInt(b);
        int big = Math.max(an, bn);
        int small = Math.min(an, bn);
        // 整除 不需要再下去了
        if (big / small >= 1 && big % small == 0) {
            times = Math.min(times, count);
            return;
        }
        for (int i = 0; i < a.length(); i++) {
            if (i == 0 || a.charAt(i) != a.charAt(i - 1)) {
                cal(a.substring(0, i) + a.substring(i + 1), b, count + 1);
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (i == 0 || b.charAt(i) != b.charAt(i - 1)) {
                cal(a, b.substring(0, i) + b.substring(i + 1), count + 1);
            }
        }
    }
}
