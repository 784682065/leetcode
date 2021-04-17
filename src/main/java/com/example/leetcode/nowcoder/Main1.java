package com.example.leetcode.nowcoder;

import java.util.Scanner;

/**
 * 异或
 */
public class Main1 {

    /**
     *
     * 异或和为0 就是两个数相等 那就是在a,b c,d区间中分别选一个数 问两个数相等概率是多少 很显然就是求交集 先求总长度 然后再求交集长度 化简成最简形式就好了
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();

            if(a > d || b < c){//不相交 左端点大于另一条右端点 右端点小于另一条左端点
                System.out.println("0/1");;
                continue;
            }


            long len = (long)(b-a+1)*(d-c+1); // 区间所有长度
            long cnt = Math.min(b, d) - Math.max(a, c) + 1;//相交长度
            long g = gcd(cnt, len);   //
            System.out.println(cnt + "/" + len);
        }
        input.close();
    }

    private static long gcd(long a, long b) {
        return b==0?a:gcd(b, a%b);
    }
}
