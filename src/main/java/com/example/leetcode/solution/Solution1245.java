package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-26 10:45
 */
public class Solution1245 {
    public int treeDiameter(int[][] edges) {
        //1. 拿到节点数
        int n = edges.length + 1; //节点数加1

        List<List<Integer>> tree = new ArrayList<>();

        //2. 生成图
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]); //前驱节点用tree的索引表示
            tree.get(edge[1]).add(edge[0]); //前驱节点用tree的索引表示
        }


        int res = 0;
        //用图的端点进行dfs
        for (int i = 0; i < n; i++) {
            //最长路径一定是从端点开始的
            if (tree.get(i).size() == 1) {
                res = Math.max(res, dfs(tree, -1, i)); //最开始的节点的前驱是-1
            }
        }

        return 0;
    }

    //dfs 当前节点所连接的全部节点,前驱节点,当前节点
    private int dfs(List<List<Integer>> tree, int pre, int cur) {

        if (tree == null) return 0;

        int res = 0;
        List<Integer> list = tree.get(cur);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != pre) { //若不是前驱节点继续下一层dfs
                res = Math.max(res, dfs(tree, cur, list.get(i))); // 现在 的节点做下一层的前驱 , 下一个要处理的节点做cur
            }

        }
        return res + 1; //返回总经过的节点数
    }


}
