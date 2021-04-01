package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  19:29 2020/4/15
 * @param:
 */
public class Main2007 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int val1 = 0;
            int val2 = 0;
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if (m > n){
                int t = m;
                m = n;
                n = t;
            }
            for (int i = m; i <= n ; i++) {
                if ( i % 2 == 0) {
                    val1 = i*i + val1 ;
                }else {
                    val2 = i*i*i +val2;
                }
            }
            System.out.println(val1 +" "+ val2);
        }

    }

}
