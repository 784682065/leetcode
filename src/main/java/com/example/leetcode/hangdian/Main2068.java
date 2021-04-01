package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 11:15
 */
public class Main2068 {

    /**
     * 错排计数。错位排列的公式有dn=n!(1-1/1!+1/2!-1/3!+...+(-1)^n*1/n!)
     * 还有一个递推的形式 d[n]=(n-1)*(d[n-1]+d[n-2]) 。
     * 其中 d[0]=1  d[1]=0 d[2]=1;这里采用第二种形式。
     * 对于N个数全排列，要求不是错排的个数大于或等于n的一半，也就是错排的个数小于或等于n的一半，即错排的个数 从0到n/2 ，
     * 对每个错排的个数都有C（n,i）种选择，i为错排的个数，
     * 在n个数中挑i个来错排，c(n,i)* d[i] 即每种错排情况的个数，累加起来即可。
     */
    static long[] arrs = new long[15];

    //初始数据
    static {
        arrs[0] = 1;
        arrs[1] = 0;
        arrs[2] = 1;
        for (int i = 3; i < 15; i++) {
            //初始化错排
            arrs[i] = (i - 1) * (arrs[i - 1] + arrs[i - 2]);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            long total = 0;
            for (int i = 0; i <= n / 2; i++)//记得要从0开始，因为0个错排，也就是没有错排，即1 2 3 4 5....也是一种情况d[0]=1；
            {
                total += c(n, i) * arrs[i];//累加
            }
            System.out.println(total);
        }
    }

    private static long c(int n, int m) {
        if ((n - m) < m) {
            m = n - m; //简化计算 c（n,i） = c(n,n-i)
        }
        long res = 1;
        for (int j = 1; j <= m; j++) {
            res = res * (n - j + 1) / j;
        }
        return res;
    }
}