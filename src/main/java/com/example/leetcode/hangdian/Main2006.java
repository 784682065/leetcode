package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  19:18 2020/4/15
 * @param:
 */
public class Main2006 {
    /**
     * 给你n个整数，求他们中所有奇数的乘积。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int mul = 1;
            int m = scanner.nextInt();
            for (int i = 0; i < m; i++) {
                int j = scanner.nextInt();
                if( j % 2 != 0){
                    mul = mul * j;
                }
            }
            System.out.println(mul);
        }
    }
}
