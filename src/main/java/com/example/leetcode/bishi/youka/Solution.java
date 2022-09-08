package com.example.leetcode.bishi.youka;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     *
     * @param str string字符串
     * @return int整型
     */
    public int strInsert (String str) {
        // write code here
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = n-2; i >=0 ; i--) {
            for (int j = i+1; j < n ; j++) {
                char a = str.charAt(i);
                char b = str.charAt(j);
                // 这个dp 代表的含义是 dp[i][j] 字符串 s[i : j] 变成回文字符串需要的操作数
                // 例如:        i j
                //       m b d a m   就是am 字符串需要一次变化就能回文,变成 m a m 或者 a m a,当i 增加的时候
                //           i   j
                //       m b d a m   就是dam , 因为 d !=m, 回文可以从 d-mam 变成 d-mam-d ,或者 dad-m 变成 m-dad-m
                if (a == b){
                    dp[i][j] = dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[0][n-1];
    }

    public int minInsertions(String s) {
        /*
        序列DP：最长回文子序列
        这题要求让s成为回文串的 最少插入次数，反过来就是求s原本有的最长回文子序列长度
        然后再插入与非回文字符数相等的字符即可
        1.状态定义:f[i][j]代表考虑s[i,j]最长回文子序列长度
        2.状态转移:要求f[i][j]就要比较s[i]与s[j]的值
            2.1 s[i]==s[j] 两个字母都要了，回文长度+2 f[i][j]=f[i+1][j-1]+2
            2.2 s[i]!=s[j] 两个字母最多只能保留一个，f[i][j]=max(f[i+1][j],f[i][j-1])
        3.初始化:f[i][i]=1，其余为0
        4.遍历顺序:i倒序，j正序 && i<j
        5.返回形式:n-f[0][n-1]
         */
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return n - f[0][n - 1];
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.strInsert("mbadm");
    }
}
