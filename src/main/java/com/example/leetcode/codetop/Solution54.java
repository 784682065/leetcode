package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int r = 0, c = 0;
        List<Integer> res = new ArrayList<>();
        int m = 0;
        while (res.size() != (matrix.length * matrix[0].length)) {
            for (int k = 0; k < 4; k++) {
                if (k == 0) {
                    while (c < matrix[r].length - m) {
                        res.add(matrix[r][c]);
                        c += 1;
                    }
                    c--;
                    r++;
                }

                if (k == 1) {
                    while (r < matrix.length - m) {
                        res.add(matrix[r][c]);
                        r += 1;
                    }
                    r--;
                    c--;
                }

                if (k == 2) {
                    while (c >= m) {
                        res.add(matrix[r][c]);
                        c -= 1;
                    }
                    r--;
                    c++;
                    m++;
                }

                if (k == 3) {
                    while (r >= m) {
                        res.add(matrix[r][c]);
                        r -= 1;
                    }
                    r++;
                    c++;
                }
                if (res.size() == (matrix.length * matrix[0].length))
                    break;
            }
        }
        return res;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        // 如果是ture 说明访问过,直接转圈
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            // 注意这边使用nextRow 提前判断下一个是不是越界了,这要就不用我的修正了
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();

        int[][] matrix = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };

        solution54.spiralOrder1(matrix);

    }
}
