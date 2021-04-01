package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  21:26 2020/4/16
 * @param:
 */
public class Main2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            int maxabs = 0;
            int maxrow = 0;
            int maxcolumn = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int val = scanner.nextInt();
                    if (Math.abs(val) > Math.abs(maxabs)) {
                        maxabs = val;
                        maxrow = i + 1;
                        maxcolumn = j + 1;
                    }
                }
            }
            System.out.println(maxrow + " " + maxcolumn + " "+maxabs);
        }

    }
}
