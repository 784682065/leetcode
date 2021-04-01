package com.example.leetcode.hangdian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 14:46
 */
public class Main2099 {

    public static void main(String[] args) {
        int a, b;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            List<String> list = new ArrayList<>();
            if (a == 0 && b == 0) {
                break;
            }
            for (int i = 0; i < 100; i++) {
                if ((a * 100 + i) % b == 0) {
                    String s;

                    if (i < 10) {
                        s = "0" + i;
                    } else {
                        s = String.valueOf(i);
                    }
                    list.add(s);
                }
            }
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }


    }
}
