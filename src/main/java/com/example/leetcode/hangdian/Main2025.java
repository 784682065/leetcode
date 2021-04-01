package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 13:53
 */
public class Main2025 {

    /**
     * 对于输入的每个字符串，查找其中的最大字母，在该字母后面插入字符串“(max)”。
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            char[] chars = s.toCharArray();
            char maxAlph = findMaxAlph(chars);
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                if (chars[i] == maxAlph) {
                    System.out.print("(max)");
                }
                if (i == chars.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    static char findMaxAlph(char[] chars) {
        char maxchar = 'A';
        for (char c : chars) {
            if (c > maxchar) {
                maxchar = c;
            }
        }
        return maxchar;
    }
}
