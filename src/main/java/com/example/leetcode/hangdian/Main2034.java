package com.example.leetcode.hangdian;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:29 2020/4/18
 * @param:
 */
public class Main2034 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (m == 0 && n == 0) {
                break;
            }

            Set<Integer> setA = new HashSet<>();
            for (int i = 0; i < n; i++) {
                setA.add(scanner.nextInt());
            }
            for (int i = 0; i < m; i++) {
                setA.remove(scanner.nextInt());
            }
            if (setA.isEmpty()) {
                System.out.println("NULL");
            } else {
                setA.stream().sorted(Integer::compare).forEach(x -> System.out.print(x + " "));
                System.out.println();
            }
        }

        scanner.close();
    }
}
