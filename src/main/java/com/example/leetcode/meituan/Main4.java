package com.example.leetcode.meituan;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        long[] longs = new long[len];
        for (int i = 0; i < len; i++) {
            longs[i] = scanner.nextLong();
        }

        for (int i = 0; i < len; i++) {

            if (i != len -1)
                System.out.println(cal(longs[i]));
            else
                System.out.print(cal(longs[i]));
        }
    }

    public static String cal(Long index) {
        // 14
        String s1 = "MeiTuannauTieMwow";
        //14
        String s2 = "wowMeiTuannauTieM";

        if (index >= s1.length()){
            return "M";
        }else {
            int i = Math.toIntExact(index);
            return String.valueOf(s1.charAt(i));
        }
    }
}
