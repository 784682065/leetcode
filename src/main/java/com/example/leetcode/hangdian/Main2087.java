package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 13:58
 */
public class Main2087 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            if (str.equals("#")) {
                break;
            }
            String sub = in.next();
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (i + sub.length() <= str.length()) {
                    if (str.substring(i, i + sub.length()).equals(sub)) {
                        sum++;
                        i = i + sub.length() - 1; //减1 是因为i 从0 开始
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
