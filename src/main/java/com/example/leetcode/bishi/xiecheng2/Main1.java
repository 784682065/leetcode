package com.example.leetcode.bishi.xiecheng2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        List<Integer> resArr = new ArrayList<>();

        for (int i = 0; i < t; i++) {

            int[][] a = new int[2][2];
            int[][] b = new int[2][2];

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    a[j][k] = sc.nextInt();
            }

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    b[j][k] = sc.nextInt();
            }

            int res = changeCount(a, b);
            resArr.add(res);
        }

        for (int i = 0; i < resArr.size(); i++) {
            if (resArr.size() == i+1){
                System.out.print(resArr.get(i));
            }else {
                System.out.println(resArr.get(i));
            }
        }

    }

    public static int changeCount(int[][] a, int[][] b) {

        if (Arrays.equals(a, b))
            return 0;

        int sum1 = 0;
        int sum2 = 0;
        int count = 0;
        // 计算1的数量
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                sum1 += a[i][j];
                sum2 += b[i][j];
                if (a[i][j] == 1) {
                    count++;
                }

            }
        }

        if (sum1 != sum2)
            return -1;

        if (count == 1) {
            // 对角线问题
            if (a[0][0] == b[1][1] &&a[0][0] ==1 || a[0][1] == b[1][0] &&a[0][1] ==1|| a[1][0] == b[0][1] &&a[1][0] ==1 || a[1][1] == b[0][0] &&a[1][1] ==1) {
                return 2;
            } else {
                return 1;
            }
        } else if (count == 2) {
            if (a[0][0] == b[0][0] || a[0][1] == b[0][1] || a[1][0] == b[1][0] || a[1][1] == b[1][1]) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 1;
        }
    }
}
