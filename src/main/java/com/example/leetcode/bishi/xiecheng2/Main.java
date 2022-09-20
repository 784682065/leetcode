package com.example.leetcode.bishi.xiecheng2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int num = 1;
        int no = 0;
        if (k % 2 == 1){
            no = ( k + 1 ) / 2;
            num = no * (no + 1);
        }else {
            no = k / 2 + 1;
            num = no * no;
        }

        float res = (float) n * n / num;

        System.out.printf("%.2f", res);
    }
}
