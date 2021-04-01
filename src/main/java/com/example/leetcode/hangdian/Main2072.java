package com.example.leetcode.hangdian;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 14:02
 */
public class Main2072 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.equals("#")) break;

            Set<String> set = new HashSet<>();
            String[] split = s.split(" ");
            for (String s1 : split) {
                set.add(s1);
            }
            //注意
            if (set.contains("")) {
                System.out.println(set.size() - 1);
            } else {
                System.out.println(set.size());
            }
        }

        scanner.close();


    }

}
