package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 14:48
 */
public class Main2074 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean boo = false;
        while (scanner.hasNext()) {
            int line = scanner.nextInt();// 行数
            String a = scanner.next();
            String b = scanner.next();
            char cha = a.charAt(0);
            char chb = b.charAt(0);
            //if...交换cha/chb , 因为cha 一定要为中心花色，最外层不一定是中心花色
            if ((line + 1) % 4 == 0) {
                char c = cha;
                cha = chb;
                chb = c;
            }
            //初始化
            char[][] ch = new char[line + 1][line + 1];
            for (int i = 0; i < ch.length; i++) {
                for (int j = 0; j < ch.length; j++) {
                    ch[i][j] = ' ';
                }
            }
            //杭电奇怪的答案格式
            if (boo) {
                System.out.println();
            }
            // 控制上半部分
            int count = ch.length;
            for (int i = 1; i < ch.length; i++) {// 控制对角线--ch[i][i]
                for (int j = i; j < count; j++) {
                    if (i % 2 != 0) {
                        ch[i][j] = cha;
                        ch[j][i] = cha;
                    } else {
                        ch[i][j] = chb;
                        ch[j][i] = chb;
                    }
                }
                count--;
            }
            /*
             * AAAAA
             * ABBB
             * ABA
             * AB
             * A
             */

            count = ch.length - 1;
            for (int i = ch.length - 1; i > ch.length - ch.length / 2; i--) {
                for (int j = i; j > ch.length - count; j--) {
                    if (i % 2 != 0) {
                        ch[i][j] = cha;
                        ch[j][i] = cha;
                    } else {
                        ch[i][j] = chb;
                        ch[j][i] = chb;
                    }
                }
                count--;
            }

            /*
                XXXXX
                XXXXA
                XXXBA
                XXBBA
                XAAAA
             */
            // 将角去掉(行数大于1的时候才去掉)
            if (line > 1) {
                ch[1][1] = ' ';
                ch[1][ch.length - 1] = ' ';
                ch[ch.length - 1][1] = ' ';
                ch[ch.length - 1][ch.length - 1] = ' ';
            }
            // 打印
            for (int i = 1; i < ch.length; i++) {
                for (int j = 1; j < ch.length; j++) {
                    System.out.print(ch[i][j]);
                }
                System.out.println();
            }
            boo = true;

        }
    }


}
