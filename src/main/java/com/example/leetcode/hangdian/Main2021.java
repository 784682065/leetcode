package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:42 2020/4/16
 * @param:
 */
public class Main2021 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = 0;
            int n = scanner.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                sum = sum + Main2021.method(scanner.nextInt());
            }
            System.out.println(sum);
        }

        scanner.close();

    }

    static int method(int i) {
        int count = 0;
        if (i >= 100) {
            count = count + i / 100;
            i = i % 100;
        }
        if (i >= 50) {
            count = count + i / 50;
            i = i % 50;
        }
        if (i >= 10) {
            count = count + i / 10;
            i = i % 10;
        }
        if (i >= 5) {
            count = count + i / 5;
            i = i % 5;
        }
        if (i >= 2) {
            count = count + i / 2;
            i = i % 2;
        }
        if (i >= 1) {
            count = count + i;
        }
        return count;
    }
}
