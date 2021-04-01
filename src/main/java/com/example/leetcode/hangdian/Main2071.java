package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 13:56
 */
public class Main2071 {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int num = Input.nextInt();
        int flag = 0;
        float[] result = new float[num];
        while (flag < num) {
            int k = Input.nextInt();
            for (int i = 0; i < k; i++) {
                if (i == 0)
                    result[flag] = Input.nextFloat();
                else
                    result[flag] = Math.max(result[flag], Input.nextFloat());
            }
            flag++;
        }
        for (float i : result) {
            System.out.printf("%.2f", i);
            System.out.println();
        }
    }
}
