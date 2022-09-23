package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution207 {

    List<List<Integer>> edges;
    /**
     * visited 数组是int , 因为有三个状态,  如果只有遍历过和没遍历过那有些路径已经遍历完成的,  后续课程需要学到这门前置知识就会报错,
     * 应当判定到当前这一轮遍历是否成环.所以要三个状态
     *
     * 如果 vv 为「未搜索」，那么我们开始搜索 vv，待搜索完成回溯到 uu；
     *
     * 如果 vv 为「搜索中」，那么我们就找到了图中的一个环，因此是不存在拓扑排序的；
     *
     * 如果 vv 为「已完成」，那么说明 vv 已经在栈中了，而 uu 还不在栈中，因此 uu 无论何时入栈都不会影响到 (u, v)(u,v) 之前的拓扑关系，以及不用进行任何操作。
     *
     */
    int[] visited;
    boolean valid = true;


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 没有这个标记遍历完成会出现 [[0,1]]这个课程错误
        visited[u] = 2;
    }


    public static void main(String[] args) {

        Solution207 solution207  = new Solution207();
//        int[][] p = {{0,1},{1,2},{2,0}};
        int[][] p = {{0,1}};
        System.out.println(solution207.canFinish(2, p));

    }
}
