package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 13:34
 */
public class Main2069 {

    //50-cent, 25-cent, 10-cent, 5-cent, and 1-cent
    public static void main(String[] args) {

        //

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 0; i <= n / 50; i++)
                for (int j = 0; j <= (n - i * 50) / 25; j++)
                    for (int k = 0; k <= (n - i * 50 - j * 25) / 10; k++)
                        for (int l = 0; l <= (n - i * 50 - j * 25 - k * 10) / 5; l++)
                            for (int m = 0; m <= (n - i * 50 - j * 25 - k * 10 - l * 5); m++)
                                if (n == i * 50 + j * 25 + k * 10 + l * 5 + m && i + j + k + l + m <= 100)  //所有的面coins数之和小于100coins
                                    sum++;

            System.out.println(sum);
        }
    }
}
