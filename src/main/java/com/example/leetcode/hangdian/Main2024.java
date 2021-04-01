package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 13:50
 */
public class Main2024 {

    static private boolean think(String s) {
        char[] k = s.toCharArray();
        //C语言合法标识符 大小写字母开头，后面为大小写字幕或者下划线或者数字
        if (k[0] == '_' || (k[0] >= 'a' && k[0] <= 'z') || (k[0] >= 'A' && k[0] <= 'Z')) {
            for (int i = 1; i < s.length(); i++) {
                if (!(k[i] == '_' || (k[i] >= 'a' && k[i] <= 'z') || (k[i] >= 'A' && k[i] <= 'Z')
                        || (k[i] >= '0' && k[i] <= '9'))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    String s1 = sc.nextLine();
                }
                String s = sc.nextLine();
                if (think(s)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }

    }

}
