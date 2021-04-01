package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 9:45
 */
public class Main2067 {
    /**
     * 卡特兰数
     * https://blog.csdn.net/qq_38238041/article/details/78452930
     * <p>
     * 排列A(n,m)=n×（n-1）.（n-m+1）=n!/（n-m）!(n为下标,m为上标,以下同)
     * 组合C(n,m)=P(n,m)/P(m,m) =n!/m!（n-m）!；
     * 例如A(4,2)=4!/2!=4*3=12
     * C(4,2)=4!/(2!*2!)=4*3/(2*1)=6
     * <p>
     * 对于HDOJ2067来讲，如果使用公式直接打表，会发现是溢出的情况，这是就需要使用递推的方式了
     * <p>
     * （1）h(n)=h(0)×h(n-1)+h(1)×h(n-2)+…+h(n-1)×h(0)     (n≥2)
     * <p>
     * （2）h(n)=((4n-2)/(n+1))×h(n-1)
     * <p>
     * （3）h(n)=C(2n,n)/(n+1)  = 2n! / (n! * (n+1)!)  (n=1，2，3，…)
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }

            long[] arr = new long[36];
            arr[0] = 1;
            function2(arr);
//            function1(arr);

            System.out.println(count + " " + n + " " + arr[n]*2); //a[i]算出是一半的路径
            count++;
        }

    }


    private static void function2(long[] arr) {
//        h(n)=h(0)×h(n-1)+h(1)×h(n-2)+…+h(n-1)×h(0) 递推式
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //完成了递推式一半的和
                arr[i] = arr[i] + arr[j] * arr[i - j - 1];
            }
        }
    }

    /**
     * 递归会超时
     * （3）h(n)=C(2n,n)/(n+1)  = 2n! / (n! * (n+1)!)  (n=1，2，3，…)
     *
     * @param arr
     */
    private static void function1(long[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = fac(i * 2) / (fac(i) * fac(i + 1));
        }
    }


    private static long fac(long n) {
        long res = 1;
        for (int i = 1; i < n; i++) {
            res *= i;
        }
        return res;
    }

}
