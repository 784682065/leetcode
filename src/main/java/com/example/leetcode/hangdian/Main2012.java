package com.example.leetcode.hangdian;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:26 2020/4/15
 * @param:
 */
public class Main2012 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x == 0 && y == 0) break;

            for (int i = x; i <= y; i++) {
                int v = i * i + i + 41;
                if (!Main2012.isPrime(v)) {
                    System.out.println("Sorry");
                    break;
                }
                if (i == y) {
                    System.out.println("OK");
                }
            }
        }


    }

    static boolean isPrime(int k) {
        for (int i = 2; i < Math.sqrt(k); i++) {

            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
