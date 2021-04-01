package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  19:54 2020/4/18
 * @param:
 */
public class Main2052 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (sn.hasNext()) {
            int width = sn.nextInt();
            int height = sn.nextInt();
            width = width + 2;
            height = height + 2;
            /*
             * width: 3 height:2
             * +---+
             * |   |
             * |   |
             * +---+
             */
            char[][] arr = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == 0 || i == height - 1) {
                        if (j == 0 || j == width - 1)
                            arr[i][j] = '+';
                        else
                            arr[i][j] = '-';
                    } else if ((i < height - 1) && (j == 0 || j == width - 1)) {
                        arr[i][j] = '|';
                    } else {
                        arr[i][j] = ' ';
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        sn.close();
    }

}
