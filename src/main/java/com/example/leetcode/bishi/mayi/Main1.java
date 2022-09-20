package com.example.leetcode.bishi.mayi;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // b -- 2^1 ,c -- 2^2 , ... , z -- 2^26

        // 1. 找一个最近的接近2的幂次的数
        int ans = 0;
        StringBuilder ansStr = new StringBuilder();
        while (n > 1) {
            for (int i = 1; i <= 26; i++) {
                if (n < Math.pow(2, i)) {
                    ans = i - 1;
                    break;
                }
            }
            n = (int) (n - Math.pow(2, ans));
            char c = (char) ('a' + ans);
            ansStr.append(c);
        }
        if (n == 1){
            ansStr.append("a");
        }

        System.out.println(ansStr.toString());
    }
}
