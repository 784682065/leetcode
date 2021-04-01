package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 10:12
 */
public class Main2082 {


    /**
     * https://blog.csdn.net/zoro_n/article/details/52841613
     */
    static long[][] dp  = new long[30][260]; //a[i][0] 表示字母数量 a[i][1]表示字母价值


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) System.out.println(0);
        while (n-- > 0) {

            int[] a = new int[30];
            for (int i = 1; i < 27; i++) {
                a[i] = scanner.nextInt();
            }


            for(int i=0; i<=26; i++)
                dp[i][0]=1;
            for(int i=1;i<=26;i++)
            {
                for(int j=0;j<=50;j++)
                {
                    dp[i][j]=dp[i-1][j];
                    for(int k=1;k<=a[i];k++)
                    {
                        if(j-i*k<0) break;
                        dp[i][j]+=dp[i-1][j-i*k];
                    }
                }
            }
            int sum=0;
            for(int i=1;i<=50;i++)
                sum+=dp[26][i];

            System.out.println(sum);

        }

    }

}
