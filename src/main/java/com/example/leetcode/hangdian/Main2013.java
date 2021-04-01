package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-16 11:03
 */
public class Main2013 {

    public static void main(String[] args) {
        // (y +1) *2
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int y = 1 ;
            for (int i = 1; i < n; i++) {
                y = (y +1) *2;
            }
            System.out.println(y);
        }
    }
}
