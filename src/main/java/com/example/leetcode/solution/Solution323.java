package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 13:43
 */
public class Solution323 {


    public int countComponents(int n, int[][] edges) {

        //构造图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        //构造visted 数组
        boolean[] visted = new boolean[n];

        int count = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (!visted[i]) {
                count += dfs(graph, i, visted);
            }
        }

        return count;
    }

    private int dfs(List<List<Integer>> graph, int i, boolean[] visted) {

        visted[i] = true;
        List<Integer> list = graph.get(i);
        for (int j = 0; j < list.size(); j++) {
            if (!visted[list.get(j)]) {
                dfs(graph, j, visted);
            }
        }
        return 1;
    }
}
