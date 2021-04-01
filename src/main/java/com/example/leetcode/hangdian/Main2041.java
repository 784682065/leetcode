package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  11:23 2020/4/18
 * @param:
 */
public class Main2041 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int numb = scanner.nextInt();
            System.out.println(calFunciotn(numb));
        }
    }

    /**
     * f(M) = f(M-1) + f(M-2)
     *
     * @param number
     * @return
     */
    static int calFunciotn(int number) {

        if (number == 1 || number == 2) {
            return 1;
        }
        return calFunciotn(number - 1) + calFunciotn(number - 2);
    }
}
