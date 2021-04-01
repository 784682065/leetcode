package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 15:03
 */
public class Main2098 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int data = sc.nextInt();
            if (data == 0) break;
            int count = 0;
            for (int i = 1; i < data / 2; ++i) {
                if (isPrime(i) && isPrime(data - i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }



    static private boolean isPrime(int data) {

        if (data < 2) return false;
        if (data == 2) return true;
        if (data % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(data); i = i + 2) {
            if (data % i == 0) return false;
        }
        return true;
    }
}
