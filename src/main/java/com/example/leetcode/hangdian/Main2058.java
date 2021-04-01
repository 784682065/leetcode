package com.example.leetcode.hangdian;


import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  21:35 2020/4/18
 * @param:
 */
public class Main2058 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int len, temp;
        while (sn.hasNext()) {
            int N = sn.nextInt();
            int M = sn.nextInt();
            if (N == 0 && M == 0)
                break;
            /*
             * len = (int) Math.sqrt(M * 2.0);
             * 思路分析：
             * 等差数列，公差为1，假设首项是a,项数是b；  等差数列求和公式：(a1+an)*n / 2;
             * 则 M = (a + (a+b-1))*b /2;
             * 所以：2M = (a + (a+b-1))*b = (2a + b - 1)*b
             * 且:a>=1
             * 所以：2M >= b^2
             * 即：项数b <= 根号2M
             */
            len = (int) Math.sqrt(M * 2.0);

            /*
             * temp = M - (i * i + i) / 2;
             * 思路分析：
             * M = (a + (a+b-1))*b /2;
             * 2M = 2ab + b^2 -b
             * 2ab = 2M - b^2 + b
             * ab = (2M - b^2 + b) / 2 = M - (b^2 - b)/2;
             * 令temp = ab;
             * temp / a = b 项数
             * temp / b = a 首项
             */
            for (int i = len; i >= 1; --i) { //这里的i就是思路中表示的b(项数) ， 和为M的项数是不超过len的
                temp = M - (i * i - i) / 2;
                if (temp % i == 0) { //首项为整数， temp 为a*b ， i 为 b
                    // 首项：(temp / i)
                    // 末项：(temp / i + i- 1) 首项+项数-1
                    System.out.println("[" + (temp / i) + "," + (temp / i + i - 1) + "]");
                }
            }
            System.out.println();
        }
        sn.close();
    }

    /**
     * 思路简单的超时
     */
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNext()) {
//            long n = scanner.nextInt();
//            long m = scanner.nextInt();
//            if (m == 0 && n == 0) break;
//
//            List<Long> longStart = new ArrayList<>();
//            List<Long> longEnd = new ArrayList<>();
//
//            for (long i = 1; i < n; i++) {
//                long sum = 0;
//                for (long j = i; j < n; j++) {
//                    sum = sum + j;
//                    if (sum == m) {
//                        longStart.add(i);
//                        longEnd.add(j);
//                        break;
//                    }
//                    if (sum > m) break;
//                }
//            }
//
//            for (int i = 0; i < longStart.size() ; i++) {
//                System.out.println("["+longStart.get(i) +","+ longEnd.get(i) +"]");
//            }
//
//            System.out.println();
//        }
//
//        scanner.close();
//
//    }

}
