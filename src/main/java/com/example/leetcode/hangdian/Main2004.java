package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-15 16:51
 */
public class Main2004 {
    /**
     * 输入一个百分制的成绩t，将其转换成对应的等级，具体转换规则如下：
     * 90~100为A;
     * 80~89为B;
     * 70~79为C;
     * 60~69为D;
     * 0~59为E;
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int x = s.nextInt();
            if (x > 100 || x < 0) {
                System.out.println("Score is error!");
            } else {
                switch (x / 10) {
                    case 10:
                    case 9:
                        System.out.println("A");
                        break;
                    case 8:
                        System.out.println("B");
                        break;
                    case 7:
                        System.out.println("C");
                        break;
                    case 6:
                        System.out.println("D");
                        break;
                    default:
                        System.out.println("E");
                        break;
                }
            }
        }
    }
}
