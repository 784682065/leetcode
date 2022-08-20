package com.example.leetcode.solution;

public class NumMatrix {

    private int[][] matrix;
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {

        preSum = new int[matrix.length][matrix[0].length];

//        初始化

        for (int i = 0; i < matrix[0].length; i++) {
            preSum[0][i] = i == 0 ? matrix[0][0] : matrix[0][i] + preSum[0][i - 1];
        }
        for (int i = 0; i < matrix.length; i++) {
            preSum[i][0] = i == 0 ? matrix[0][0] : matrix[i][0] + preSum[i - 1][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i][j] - preSum[i - 1][j - 1];
            }
        }
    }

    // 主要是从全局观上看,
    // 1. 前缀和,
    // 2. 不是前缀和的长方形去做减法.
    public int sumRegion(int row1, int col1, int row2, int col2) {

        int left = col1 > 0 ? preSum[row2][col1 - 1] : 0;
        int top = row1 > 0 ? preSum[row1 - 1][col2] : 0;
        int leftTop = row1 > 0 && col1 > 0 ? preSum[row1 - 1][col1 - 1] : 0;

        return preSum[row2][col2] - left - top + leftTop;
    }

    public static void main(String[] args) {

        int[][] m = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(m);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));


    }


}
