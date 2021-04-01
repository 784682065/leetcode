package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  15:07 2020/4/18
 * @param:
 */
public class Main2046 {

    /**
     *
     * 只要简单的推断即可~
     * 假设用arr[i]表示2*i的方格一共有组成的方法数，我们知道arr[1]=1;arr[2]=2;
     * 现在假设我们已经知道了arr[i-1]和arr[i-2],求arr[i],所谓arr[i],不过是在2*（i-1）的格子后边加上一格2*1的方格罢了，骨牌在这一格上横着放，竖着放，如果前面i-1块已经铺好，则第i块只有一种铺法，就是竖着放，如果要横着放，也只有一种铺法，不过要求前面i-2块已经铺好！
     * 因此arr[i]=arr[i-1]+arr[i-2];
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (sn.hasNext()) {
            int n = sn.nextInt(); //表示该测试实例的长方形方格的规格是2×n (0<n<=50)
			/*
			 * n=1,1
			   n=2,2
			   n=3,3
    	 	   n=4,5
			 */
            System.out.println(compute(n));
        }
        sn.close();
    }

    static long[] arr = new long[60];

    public static long compute(int n) {
        if (arr[n] != 0)
            return arr[n];
        if (n == 1)
            return arr[n] = 1;
        else if (n == 2)
            return arr[n] = 2;
        else
            return arr[n] = compute(n - 1) + compute(n - 2);
    }
}