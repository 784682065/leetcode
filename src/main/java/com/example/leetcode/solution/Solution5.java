package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-23 9:56
 */
public class Solution5 {

    public static void main(String[] args) {
        String babad = longestPalindrome("aaabaaaa");
        System.out.println(babad);
    }

    /**
     * 算法实现的步骤
     * <p>
     * 1、创建一个一维数组或者二维数组，保存每一个子问题的结果，具体创建一维数组还是二维数组看题目而定，基本上如果题目中给出的是一个一维数组进行操作，就可以只创建一个一维数组，如果题目中给出了两个一维数组进行操作或者两种不同类型的变量值，比如背包问题中的不同物体的体积与总体积，找零钱问题中的不同面值零钱与总钱数，这样就需要创建一个二维数组。
     * <p>
     * 注：需要创建二维数组的解法，都可以创建一个一维数组运用滚动数组的方式来解决，即一位数组中的值不停的变化，后面会详细徐叙述
     * <p>
     * 2、设置数组边界值，一维数组就是设置第一个数字，二维数组就是设置第一行跟第一列的值，特别的滚动一维数组是要设置整个数组的值，然后根据后面不同的数据加进来变幻成不同的值。
     * <p>
     * 3、找出状态转换方程，也就是说找到每个状态跟他上一个状态的关系，根据状态转化方程写出代码。
     * <p>
     * 4、返回需要的值，一般是数组的最后一个或者二维数组的最右下角
     */
    public static String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        //dp [i][j] 代表s.substring(i,j) ，true 为回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        //初始化对角线
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //如果字符 i 与j 相等，且距离小于3必定回文
                    if (j - i <= 3) { //不能等于3 , aba 为3-1 = 2 三个字母差值最大为2
                        dp[i][j] = true;
                    } else {
                        //若不小于3 则他的状态等于上面一层 dp[i+1][j-1]
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        int max = 1;
        int start = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                    }

                }
            }
        }
        return s.substring(start, start + max);
    }
}
