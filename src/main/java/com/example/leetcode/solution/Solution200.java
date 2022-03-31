package com.example.leetcode.solution;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hzp
 * @date: 2022/3/31
 * @description: 官方解答是把原先数据的1 改成0 空间效率upup
 */
public class Solution200 {

    boolean[][] barrs;

    public int numIslands(char[][] grid) {

        int count = 0;
        char pos;
        barrs = new boolean[grid.length][grid[0].length];
//        Arrays.fill(barrs,false);
        // 找到个1 就一直拓展
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                pos = grid[i][j];
                // 如果是上下边缘就不在探索
                if (pos == '1' && !barrs[i][j]) {
                    //拓展填充barrs
                    Fillbarrs(grid, i, j);
                    count++;
                }

            }
        }


        return count;
    }

    // 找一个口子一直找到底
    private void Fillbarrs(char[][] grid, int i, int j) {


        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || barrs[i][j])
            return;

        if (grid[i][j] == '1') {
            barrs[i][j] = true;
        } else {
            return;
        }

        Fillbarrs(grid, i, j + 1);
        Fillbarrs(grid, i, j - 1);
        Fillbarrs(grid, i - 1, j);
        Fillbarrs(grid, i + 1, j);
    }

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int i = solution200.numIslandsBfs(grid);
        System.out.println(i);

    }

    // 一圈一圈往外面找
    public int numIslandsBfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);  // 表示这个值在数组中的位置第几个数
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }


}
