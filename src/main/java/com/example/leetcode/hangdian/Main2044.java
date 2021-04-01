package com.example.leetcode.hangdian;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  14:09 2020/4/18
 * @param:
 */
public class Main2044 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        // 输入数据的第一行是一个整数N,表示测试实例的个数，然后是N 行数据，每行包含两个整数a和b(0<a<b<50)。
        int n = sn.nextInt();
        BigInteger[] arr = new BigInteger[55];

        arr[1] = new BigInteger("1");
        arr[2] = new BigInteger("2");

        for (int i = 3; i < 50; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);

        }
        for (int i = 0; i < n; i++) {
            int a = sn.nextInt();
            int b = sn.nextInt();
            System.out.println(arr[b - a]);
        }
        sn.close();
    }

    /**
     * 递归超时
     */
    static int calFunction(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return calFunction(n - 1) + calFunction(n - 2);
    }
}
