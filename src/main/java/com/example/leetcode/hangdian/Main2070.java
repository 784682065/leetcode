package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 13:51
 */
public class Main2070 {

    static long[] fab;
    static {
        fab = new long[51];
        fab[0] = 0; fab[1] = 1;
        for (int i = 2; i < 51; i++) {
            fab[i] = fab[i-1] + fab[i-2];
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n == -1) break;

            System.out.println(fab[n]);
        }

        scanner.close();
    }
}
