package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 14:42
 */
public class Main2084 {
    /**
     * DP 动态规划
     * <p>
     * 具体运算过程就是，建立一个n*n的二维数组dp[][]，
     * n是数字塔最后一行的数字个数，二维数组每一行数字跟数字塔每一行数字个数一样，
     * 保存的值是从上方到这一个位置最大路径的值，填入边界值dp[0][0]=3，
     * 每一行除了第一个值跟最后一个值，
     * 其他的值选择上方或者左上方更大的值与这个位置上的值相加得来的值，
     * 即dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j]) + n[i][j]
     */

    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) {

        /**
         * 1、创建一个一维数组或者二维数组，保存每一个子问题的结果，具体创建一维数组还是二维数组看题目而定，基本上如果题目中给出的是一个一维数组进行操作，就可以只创建一个一维数组，如果题目中给出了两个一维数组进行操作或者两种不同类型的变量值，比如背包问题中的不同物体的体积与总体积，找零钱问题中的不同面值零钱与总钱数，这样就需要创建一个二维数组。

         注：需要创建二维数组的解法，都可以创建一个一维数组运用滚动数组的方式来解决，即一位数组中的值不停的变化，后面会详细徐叙述

         2、设置数组边界值，一维数组就是设置第一个数字，二维数组就是设置第一行跟第一列的值，特别的滚动一维数组是要设置整个数组的值，然后根据后面不同的数据加进来变幻成不同的值。

         3、找出状态转换方程，也就是说找到每个状态跟他上一个状态的关系，根据状态转化方程写出代码。

         4、返回需要的值，一般是数组的最后一个或者二维数组的最右下角。
         ————————————————
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n-- > 0) {
            int cs = scanner.nextInt();

            arr = new int[cs][cs];
//            Arrays.fill(arr, 0);
            //数据初始录入
            for (int i = 0; i < cs; i++) {
                for (int j = 0; j <= i; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            dp = new int[cs][cs];
            dp[0][0] = arr[0][0]; //初始化状态
            int max = dp[0][0];
            for (int i = 1; i < cs; i++) { //　ｉ　从１　开始
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        // 边界状态：第一列没有左上角
                        //如果是第一列，直接跟他上面数字相加
                        dp[i][j] = dp[i - 1][j] + arr[i][j];
                    } else {
                        //状态转移方程
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
            System.out.println(max);

        }

    }
}
