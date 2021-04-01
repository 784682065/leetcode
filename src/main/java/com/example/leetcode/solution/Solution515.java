package com.example.leetcode.solution;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-28 8:58
 */
public class Solution515 {

    public static class Pair {
        TreeNode node;
        int height;

        public Pair(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        //层次遍历
        Queue<Pair> queue = new ArrayDeque<>();
        Pair pair = new Pair(root, 0);
        //初始化队列 和list
        queue.add(pair);
        list.add(root.val); //等一层肯定root 值最大

        while (!queue.isEmpty()) {
            Pair pair1 = queue.poll();
            TreeNode node = pair1.node;
            //若是找到那一层比较大的数 则换
            if (pair1.height >= list.size()) {
                list.add(pair1.height, node.val);
            } else if (node.val > list.get(pair1.height)) {
                list.remove(pair1.height);
                list.add(pair1.height, node.val);
            }

            if (node.right != null) {
                queue.add(new Pair(node.right, pair1.height + 1));
            }
            if (node.left != null) {
                queue.add(new Pair(node.left, pair1.height + 1));
            }
        }
        return list;
    }

}
