package com.example.leetcode.bishi.netez;

import java.util.Scanner;

// 31.58
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        long times = goode(str);
        System.out.println(times);

    }

    private static long goode(String str) {

        if (str.length()<3){
            return 0;
        }

        return 1;
    }


}
