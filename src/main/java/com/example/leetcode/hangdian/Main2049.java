package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  17:02 2020/4/18
 * @param:
 */
public class Main2049 {

    /*
     * 一共有N对新婚夫妇,其中有M个新郎找错了新娘,隐含条件：有N-M个新郎一定是找对了新娘的
     * 假设一共有N对新婚夫妇,其中有M个新郎找错了新娘,求发生这种情况一共有多少种可能
     * 则首先从N个新郎中选出M个新郎，剩下N-M个新郎肯定是选对的，
     * 然后这M个新郎只对应M个新娘（因为有N-M个新郎是选对了的，所以N-M个新娘已经被选了）
     * 然后要错选，则只能是M的完全错排
     * 错排公式:f(n) = (n-1)[f(n-2)+f(n-1)] (n>2)
     * 最后结果：result = cnm * a[m];//C(n,m)*f(m)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (number-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            long[] a = new long[21];
            a[0] = 0;
            a[1] = 0;
            a[2] = 1;
            for (int i = 3; i < a.length; i++) {
                a[i] = (i - 1) * (a[i - 1] + a[i - 2]);
            }
            //C(n,m)
            long temp1 = 1;
            long temp2 = 1;
            for (int i = n; i >= n - m + 1; i--) {
                temp1 = i * temp1;
            }
            for (int i = 1; i <= m; i++) {
                temp2 = i * temp2;
            }
            long cnm = temp1/temp2 ;
            long res = a[m] * cnm;
            System.out.println(res);
        }

    }
}
