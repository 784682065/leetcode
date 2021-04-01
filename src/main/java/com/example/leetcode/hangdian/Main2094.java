package com.example.leetcode.hangdian;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 8:34
 */
public class Main2094 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int nextInt = scanner.nextInt();
//            scanner.nextLine();
            if (nextInt == 0) break;

            Set<String> wins = new HashSet();
            Set<String> losers = new HashSet();
            for (int i = 0; i < nextInt; i++) {
                wins.add(scanner.next());
                losers.add(scanner.next());
            }
            wins.removeAll(losers);
            if (wins.size() > 1 || wins.size() == 0) {
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}
