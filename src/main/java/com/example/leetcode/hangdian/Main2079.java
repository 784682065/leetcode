package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 8:34
 */
public class Main2079 {

    static int T;
    static int n, k;
    static int count; //总数
    static int[][] a;

    /**
     * DFS  + 剪枝
     **/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        if (T == 0) System.out.println(0); //有点坑的条件

        for (int i = 0; i < T; i++) {
            n = scanner.nextInt(); //需要n个学分
            k = scanner.nextInt(); //k个数据
            count = 0; //每次算学分count 重置
            a = new int[k][2];
            for (int j = 0; j < k; j++) {
                a[j][0] = scanner.nextInt(); // 放 学分
                a[j][1] = scanner.nextInt(); // 放 课程数
            }
            dfs(0, 0);
            System.out.println(count);
        }
    }

    /**
     * 深度搜索
     *
     * @param start 开始点
     * @param sum   总分
     */
    private static void dfs(int start, int sum) {

        if (sum == n) {
            count++;
            return;
        }
        if (sum > n || start >= k) { //总分超过 ，或者课程数超过 就return 剪枝
            return;
        }

        for (int i = 0; i <= a[start][1]; i++) {  //i 从0 开始表示可以不选这个课
            dfs(start + 1, sum + i * a[start][0]);
        }

    }

}
