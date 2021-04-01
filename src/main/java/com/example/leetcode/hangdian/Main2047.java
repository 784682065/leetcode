package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  15:44 2020/4/18
 * @param:
 */
public class Main2047 {

    /**
     * 第n种情况可以填入的字符串有E,O,F三种情况
     * 1.当填E时，前面n-1个填的方法数是a[n-1]，
     * 2.当填F时，前面n-1个填的方法数是a[n-1]，
     * 3.当填O时，因为相邻两个不能是O,O，所以第n-1种只能填E，F，因为a[n-1]的第n-1种必须E,O,F都要填入，
     * （关键弄清a[n-1]代表什么意义,能填三种字符的才是a【n-1】，不满足就继续往前找a[n-2]，直到满足为止）
     * 所以往前看第n-2种，因为第n-1种只能填E,F，所以第n-2种可填入三种字符，即a[n-2]，
     * 所以填n时的方法数为2*a[n-2] + 2* a[n-1]
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //要用long存储
            long[] a = new long[50];
            a[1] = 3;
            a[2] = 8;
            for (int i = 3; i <= n; i++) {
                a[i] = 2 * a[i - 1] + 2 * a[i - 2];
            }
            System.out.println(a[n]);
        }
    }
}
