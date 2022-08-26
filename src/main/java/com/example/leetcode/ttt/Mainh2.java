package com.example.leetcode.ttt;

import java.util.Scanner;

public class Mainh2 {

    static int[][] dir = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static int[][] dir1 = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] nums = new int[m][n];
        // 判断是否全是0
        boolean sign = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = scanner.nextInt();
                nums[i][j] = num;
                if (num ==1){
                    sign = true;
                }

            }
        }
        res = 0;

        if (!sign){
            nums[0][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int[][] nums, int i, int j) {

        for (int[] ints : dir) {
            int x = i + ints[0];
            int y = j + ints[1];
            if (x >= 0 && x < nums.length && y >= 0 && y < nums[0].length) {
                if (nums[x][y] == 0 && check(nums, x, y)) {
                    nums[x][y] = 1;
                    res++;
                    dfs(nums, x, y);
                }
            }
        }
    }
    private static boolean check(int[][] nums, int i, int j) {

        for (int[] ints : dir1) {
            int  x = i + ints[0];
            int y = j + ints[1];
            if (x >= 0 && x < nums.length && y >= 0 && y < nums[0].length) {
                if (nums[x][y] == 1)
                    return false;
            }
        }
        return true;
    }
}
