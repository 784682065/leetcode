package com.example.leetcode.hangdian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 13:29
 */
public class Main2088 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            if (n == 0) break;
            if (flag){
                System.out.println();
            }

            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int nextInt = scanner.nextInt();
                list.add(nextInt);
                sum += nextInt;
            }
            Collections.sort(list);

            int res = 0;
            for (Integer integer : list) {
                if (integer > sum / n) {
                    res += integer - sum / n;
                }
            }
            System.out.println(res);

            flag =true;
        }
        scanner.close();
    }


}
