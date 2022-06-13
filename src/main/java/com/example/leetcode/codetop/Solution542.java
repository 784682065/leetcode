package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {

    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 类似于海洋岛屿
    // 可以先来bfs
    public int[][] updateMatrix(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    bfs(mat, i, j);
            }
        }

        return mat;
    }

    private void bfs(int[][] mat, int i, int j) {
        boolean[][] vis = new boolean[mat.length][mat[i].length];
        vis[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j, 0});

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                for (int[] ints : move) {
                    int row = poll[0] + ints[0];
                    int col = poll[1] + ints[1];
                    // 如果未曾遍历过则加入
                    if (inArea(row, col, mat.length, mat[i].length) && !vis[row][col]) {
                        if (mat[row][col] == 0) {
                            // 找到最近的
                            mat[i][j] = poll[2] + 1;
                            return;
                        } else {
                            queue.offer(new int[]{row, col, poll[2] + 1});
                        }
                        vis[row][col] = true;
                    }
                }
            }
        }
    }

    private boolean inArea(int row, int col, int length, int ilength) {
        return row >= 0 && row < length && col >= 0 && col < ilength;
    }


    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrixMultipleSource(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    // 把已经加入的点设置成 true 就好 . 解决遍历到自己的问题
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                // 在区域内,且没看过,那一定是1
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    // 可以进行queue.offer与seen[ni][nj] 是因为被0 包围的0 根本出不去!seen[ni][nj]这个条件
                    // 同时 是1 的节点应该加入queue 设置成已经遍历过,不然被1包围的1也见不到
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;
    }


    public static void main(String[] args) {
//        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] mat = {{0},{0},{0},{0},{0}};
        Solution542 solution542 = new Solution542();
        solution542.updateMatrix(mat);
        System.out.println(Arrays.deepToString(mat));
    }
}
