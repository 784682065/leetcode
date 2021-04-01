package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 14:19
 */
public class Main2016 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int n = s.nextInt();
            if (n == 0) {
                break;
            }

            int[] ints = new int[n];
            int minVal = Integer.MAX_VALUE;
            int minPos = 0;
            for (int i = 0; i < n; i++) {
                ints[i] = s.nextInt();
                if (ints[i] < minVal) {
                    minVal = ints[i];
                    minPos = i;
                }
            }
            int temp = ints[0];
            ints[0] = ints[minPos];
            ints[minPos] = temp;

            for (int i = 0; i < ints.length; i++) {
                if (i < ints.length - 1) {
                    System.out.printf(ints[i] + " ");
                } else {
                    System.out.println(ints[i]);
                }
            }
        }
        s.close();
    }
}
