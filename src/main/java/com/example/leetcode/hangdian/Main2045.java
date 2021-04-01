package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  14:42 2020/4/18
 * @param:
 */
public class Main2045 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            long[] a = new long[60];
            a[0] = 3;
            a[1] = 6;
            a[2] = 6;
            for (int i = 3; i < n; i++) {
                a[i] = a[i - 1] + a[i - 2] * 2;
            }

            System.out.println(a[n - 1]);
        }

    }

    /**
     * 但是花费时间太久
     * 递推，f(1)=3,f(2)=6,f(3)=6
     * ２如果有n个方格，当对第n个方格填色时，有两种情况：
     * １）应该已经对前面n-1个方格填好了色，有f(n-1)种情况，此时第n-1个跟第一个颜色一定不一样，所以第n个只有一种选择。
     * ２）对前面n-2个方格填好色，有f(n-2)种情况，第n-1个空格颜色跟第一个颜色一样，只有一种可能，最后第n个方格可以填两种颜色（因为n-１和１是第同种颜色），所以是　２*f(n-2);
     * 可以推出f(n)=f(n-1)+2(n-2),n>=4;
     */
    static long calFunction(int n) {
        if (n == 1) return 3;
        if (n == 2 || n == 3) return 6;
        return calFunction(n - 1) + calFunction(n - 2) * 2;
    }
}

