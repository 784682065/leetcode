package com.example.leetcode.ttt;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        float a = 1 ,b = 2 , sum = 0;
        float temp;
        for (int i = 0; i < n; i++) {
            sum+= (a/b);
            temp = b;
            b = a+b;
            a = temp;
        }
        System.out.println(sum);
    }
}
