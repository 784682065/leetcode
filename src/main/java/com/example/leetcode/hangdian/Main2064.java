package com.example.leetcode.hangdian;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  14:40 2020/4/19
 * @param:
 */
public class Main2064 {

    /**
     * 总结通项公式 fn = 3* fn-1  + 2
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            BigInteger res = hanno(i);
            System.out.println(res);
        }

    }

    private static BigInteger hanno(int i) {
        if (i == 1) {
            return BigInteger.valueOf(2);
        } else {
            return BigInteger.valueOf(3).multiply(hanno(i - 1)).add(BigInteger.valueOf(2));
        }
    }


}
