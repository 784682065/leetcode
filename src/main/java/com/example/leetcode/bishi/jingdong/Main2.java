package com.example.leetcode.bishi.jingdong;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 6) {
            System.out.println(0);
            return;
        }
        if (n % 3 == 0) {
            System.out.println(n / 3 - 1);
            return;
        }
        int temp = n - 6;
        long res = (long) ((((temp + 2) * (temp + 1) * Math.pow(26, temp) / 2)) % (1000000000 + 7));
        System.out.println(res);
    }

}
