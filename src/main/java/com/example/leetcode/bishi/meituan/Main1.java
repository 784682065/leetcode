package com.example.leetcode.bishi.meituan;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());


        String[] s = scanner.nextLine().split(" ");
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < s.length; k++) {
            int c = 0;
            int i;
            int j;
            for (i = 0; i <= k; i++) {
                if (s[i].equals("0") || s[i].equals("1")){
                    c++;
                }
            }
            for (j = i; j < s.length; j++) {
                if (s[j].equals("0") || s[j].equals("-1")){
                    c++;
                }
            }
            min = Math.min(c,min);
        }

        System.out.println(min);
    }
}
