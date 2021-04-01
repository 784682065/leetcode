package com.example.leetcode.hangdian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 15:48
 */
public class Main2083 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) System.out.println(0);
        while (n-- > 0) {
            int m = scanner.nextInt();
            List<Integer> a = new ArrayList();
            for (int i = 0; i < m; i++) {
                a.add(scanner.nextInt());
            }
            Collections.sort(a);
            int ans = 0;
            for (int i = 0; i < a.size() / 2; i++) {
                ans += a.get(a.size() / 2) - a.get(i);
            }
            for (int i = a.size() / 2; i <  a.size(); i++) {
                ans += a.get(i) - a.get(a.size() / 2);
            }
            System.out.println(ans);
        }
    }

}
