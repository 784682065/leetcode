package com.example.leetcode.bishi.jingdong;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        String str = scanner.nextLine();
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char charAt = str.charAt(i);
            if (i < k) {
                //变大写
                if (Character.isLowerCase(charAt)){
                    charAt = (char) (charAt - 32);
                }
            } else {
                if (!Character.isLowerCase(charAt)){
                    charAt = (char) (charAt + 32);
                }
            }
            sb.append(charAt);
        }
        System.out.println(sb);
    }


}
