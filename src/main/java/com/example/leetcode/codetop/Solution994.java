package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution994 {


    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrg = 0;
        // 先找出所有烂橘子的位置, 记录新鲜橘子的个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshOrg++;
                }
            }
        }

        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        //bfs 一轮看橘子个数是否为0 ,不为0 继续烂,直到BFS不下去
        //若是烂完了,返回当前分钟数
        int mins = 0;
        while (!queue.isEmpty() && freshOrg > 0) {
            // 时间加1
            mins++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] mv : move) {

                    // 四个方向拓展
                    int r1 = poll[0] + mv[0];
                    int c1 = poll[1] + mv[1];

                    //在区域内 , 且有新鲜橘子
                    if ((r1 >= 0 && r1 < m && c1 >= 0 && c1 < n) && grid[r1][c1] == 1) {
                        grid[r1][c1] = 2; // 变烂

                        // 加入队列
                        queue.offer(new int[]{r1, c1});
                        // 新鲜橘子减1
                        freshOrg--;
                    }

                }

            }
        }


        //若烂到最后,还有新鲜橘子返回-1
        if (freshOrg > 0) {
            return -1;
        }


        return mins;
    }

    public static void main(String[] args) {
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] grid = {{0,2}};

        Solution994 solution994 = new Solution994();
        int i = solution994.orangesRotting(grid);

        System.out.println(i);


    }
}
