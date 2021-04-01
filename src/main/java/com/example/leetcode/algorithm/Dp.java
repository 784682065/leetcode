package com.example.leetcode.algorithm;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 15:09
 */
public class Dp {

    public static void main(String[] args) {
//        int[] a  = {3,1,4,1,5,9,2,6,5};
////        int i = MaxChildArrayOrder(a);
////        System.out.println(i);
//        int[][] a = new int[][]{{1, 0, 0}, {2, 3, 0}, {4, 5, 6}};
//        int i = minNumberInRotateArray2(a);
        int n = 5;
        int v = 8;
        int[] w ={0,6,1,5,2,1};
        int[] p ={0,48,7,40,12,8};
        int i = PackageHelper2(n, w, p, v);
    }

    public static int MaxChildArrayOrder(int a[]) {
        int n = a.length;
        int temp[] = new int[n];//temp[i]代表0...i上最长递增子序列
        for (int i = 0; i < n; i++) {
            temp[i] = 1;//初始值都为1
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && temp[j] + 1 > temp[i]) {
                    //如果有a[i]比它前面所有的数都大，则temp[i]为它前面的比它小的数的那一个temp+1取得的最大值
                    temp[i] = temp[j] + 1;
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for (int i = 1; i < n; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }


    public static int minNumberInRotateArray2(int n[][]) {
        int[] temp = new int[n.length]; //temp 保存到最后一行的状态
        temp[0] = n[0][0];
        for (int i = 1; i < n.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    temp[i] = temp[i - 1] + n[i][j];
                } else if (j == 0) {
                    temp[0] += n[i][0];
                } else {
                    temp[j] = Math.max(temp[j], temp[j - 1]) + n[i][j];
                }
            }
        }
        int max = temp[0];
        //从temp数组里取出最大的值
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }
        return max;
    }


    /**
     *
     * @param n 物品总数
     * @param w 重量数组
     * @param p 价值数组
     * @param v 总容纳重量
     * @return
     */
    public static int PackageHelper(int n,int w[],int p[],int v) {
        //设置一个二维数组，横坐标代表从第一个物品开始放到第几个物品，纵坐标代表背包还有多少容量，dp代表最大价值
        int dp[][] = new int[n+1][v+1];
        //i 代表 当前装的是第几个物品
        for(int i=1;i<n+1;i++){
            //j 代表当前可容纳空间
            for(int j=1;j<=v;j++){
                if(j>=w[i]){
                    /*
                     * 当能放得下这个物品时，放下这个物品，价值增加，但是空间减小，最大价值是dp[i-1][j-w[i]]+p[i]
                     * 当不放这个物品时，空间大，物品还是到i-1，最大价值是dp[i-1][j]
                     * 比较这两个大小，取最大的，就是dp[i][j]
                     * j-w[i] 实际上是贪心思想，想办法装满，所以就从空间为j -w[i]的开始装
                     */
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+p[i]);
                }else{
                    //如果放不下，就是放上一个物品时的dp
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][v];
    }

    /**
     * 优化：滚动数组，只创建一个一维数组，长度为从1到W，初始值都是0，
     * 能装得下i时，dp[j] = Math.max(dp[j], dp[j-w[i]]+p[i])；装不下时，dp[j] = dp[j];
     */
    public static int PackageHelper2(int n,int w[],int p[],int v) {
        //只创建一个一维数组，长度为从1到W，初始值都是0
        int dp[] = new int[v+1];
        for(int i=1;i<=n;i++){
            for(int j=v;j>0;j--){
                if(j>w[i]){
                    dp[j] = Math.max(dp[j], dp[j-w[i]]+p[i]);
                }else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[v];
    }

}
