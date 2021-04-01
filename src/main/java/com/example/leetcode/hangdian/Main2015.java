package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 11:29
 */
public class Main2015 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int times = (n % m == 0) ? n / m : n / m + 1;
            int count = 1;
            for (int i = 0; i < times; i++) {
                int sum = 0;
                if (i == times - 1) {
                    for (int j = i * m; j < n; j++) {
                        sum = sum + count * 2;
                        count++;

                    }
                    System.out.print(sum / (n - i * m) + "\r\n");
                } else {
                    for (int j = i * m; j < i * m + m; j++) {
                        sum = sum + count * 2;
                        count++;
                    }
                    System.out.print(sum / m + " ");
                }
            }
        }


    }
}
