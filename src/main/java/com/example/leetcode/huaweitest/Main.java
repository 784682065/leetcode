package com.example.leetcode.huaweitest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {

            int xi = in.nextInt();
            int ni = in.nextInt();
            int di = in.nextInt();
            //放下或者拿走一个
            arr[xi] += ni;
            if (di == 0) {
                // 左移
                int index;
                for (int k = 0; k < arr.length - 1; k++) {
                    index = k + 1;
                    arr[k] = arr[index];
                }
                arr[arr.length - 1] = 0;
            }
            if (di == 1) {
                int index;
                for (int k = arr.length - 1; k > 0; k--) {
                    index = k - 1;
                    arr[k] = arr[index];
                }
                arr[0] = 0;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + " ");
            else
                System.out.println(arr[i]);
        }

    }
}
