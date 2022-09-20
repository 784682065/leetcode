package com.example.leetcode.bishi.xiecheng2;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        long res = 0;
        // 有这么多个值可以乘以4
        long num = (n - 2) * (n - 2);
        // 有这么多个值可以乘以3
        long num1 = n * n - num - 4;

        // 可以有这么多个数 *4
        long sum = (n * n) + (n * n - num + 1);
        long temp = sum * (num / 2) + (sum / 2) * (num % 2);
        res += (temp * 4);

        long sum1 = (n * n - num + 5);
        long temp1 =  sum1 * (num1 / 2) + (sum1 / 2) * (num1 % 2);;
        res += (temp1 * 3);

        // (4+3+2+1)*2
        // 有四个值可以乘2
        long num2 = 4;
        res += 20;
        int ans = (int) (res % (Math.pow(10, 9) + 7));
        System.out.println(ans);

    }

}
