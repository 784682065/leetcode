package com.example.leetcode.netez;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 方格矩阵Cn下标
     * @param x1 int整型 方格1在方格矩阵中的横坐标
     * @param y1 int整型 方格1在方格矩阵中的纵坐标
     * @param x2 int整型 方格2在方格矩阵中的横坐标
     * @param y2 int整型 方格2在方格矩阵中的纵坐标
     * @return long长整型
     */
    public long solution (int n, int x1, int y1, int x2, int y2) {
        // write code here


        double pow = Math.pow(Math.abs(x1 - x2), 2);
        double pow1 = Math.pow(Math.abs(y1 - y2), 2);



        return (long) Math.pow(pow + pow1,0.5);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1, 1, 1, 2, 1));
    }
}
