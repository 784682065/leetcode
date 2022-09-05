package com.example.leetcode.bishi.shunfeng;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long ans = 1;
        int times = (int) (Math.log(n) / Math.log(2));
        for (int i = 1; i <= times; i++) {
            double res = (i != times ? (Math.pow(2, i + 1) - Math.pow(2, i)) : (n + 1 - Math.pow(2, i)));
            ans += res * (i + 1);
        }
        System.out.println(ans);
    }
}
