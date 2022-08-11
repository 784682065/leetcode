package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution48 {
    static int[][] dir = {
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int clo = row;


        int beginRow = 0, beginClo = 0;
        int beginReRow = beginRow, beginReClo = clo - 1;
        while (beginRow < clo - 1) {

            for (int[] ints : dir) {
                for (int i = beginClo; i < clo - 1; i++) {
                    swap(matrix, beginRow, i, beginReRow, beginReClo);
                    beginReRow += ints[0];
                    beginReClo += ints[1];
                }
            }
            beginRow += 1;
            beginClo += 1;
            row -=1;
            clo -=1;
            beginReRow = beginRow;
            beginReClo = clo - 1;
        }
    }

    public void swap(int[][] matrix, int i, int j, int k, int l) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }


    public void rotateOF(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

//        solution48.rotate(matrix);
        solution48.rotateOF(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
