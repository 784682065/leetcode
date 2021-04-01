package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 15:34
 */
public class Main2075 {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int num = Input.nextInt();
        int flag = 0;
        String[] result = new String[num];
        while (flag < num) {
            int m = Input.nextInt();
            int n = Input.nextInt();
            if (m % n == 0)
                result[flag] = "YES";
            else
                result[flag] = "NO";
            flag++;
        }
        for (String i : result) {
            System.out.println(i);
        }
    }

}
