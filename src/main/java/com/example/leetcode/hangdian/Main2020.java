package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:11 2020/4/16
 * @param:
 */
public class Main2020 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                ints[i] = scanner.nextInt();
            }
            Main2020.sortedABS(ints);

            for (int i = 0; i < ints.length; i++) {

                if (i != ints.length - 1) {
                    System.out.printf(ints[i] + " ");
                }else {
                    System.out.printf(ints[i] + "\r\n");
                }
            }
        }

        scanner.close();

    }

    //冒泡排序
    static void sortedABS(int[] ints) {
        int temp;
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = ints.length - 1; j > i; j--) {
                if (Math.abs(ints[j]) > Math.abs(ints[j - 1])) {
                    temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                }
            }
        }

    }


}


