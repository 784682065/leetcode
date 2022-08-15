package com.example.leetcode.netez;

import java.util.Scanner;

public class Main1 {

    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        // 拿到宝箱序列号
        int bound = Integer.parseInt(scanner.nextLine());
        count = 0;
        count252(25, bound);
//        if (bound > 25) {
//            count++;
//        }
        System.out.println(count);
    }

    private static int count25(int bound) {
        int count = 0;
        for (int i = 1; i <= bound; i++) {
            String s = String.valueOf(i);
            int bcs = 1;
            if (s.contains("25")) {
                count++;
            }
        }
        return count;
    }

    private static void count252(int startVal, int bound) {
        if (bound < startVal) {
            return;
        }

        // 加前面
        int v2 = startVal;
        while (v2 <= bound) {
            StringBuilder sb = new StringBuilder();
            sb.append(9).append(v2);
            v2 = Integer.parseInt(sb.toString());
            count += 9;
        }
        String s = String.valueOf(v2);
        String sv2 = s.substring(1);
        for (int i = 0; i < 10 ; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(sv2);
            if (Integer.parseInt(sb.toString()) <=bound){
                count++;
            }
        }
        count -=9;

        // 加后面
        int v1 = startVal;
        while (v1 <= bound) {
            v1 = v1 * 10;
            count *= 10;
        }

        String s1 = String.valueOf(v1);
        String sv1 = s.substring(1);
        for (int i = 0; i < 10 ; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sv1).append(i);
            if (Integer.parseInt(sb.toString()) >bound){
                count-=10;
            }
        }
        // 做减法
//        count -=10;

    }


}
