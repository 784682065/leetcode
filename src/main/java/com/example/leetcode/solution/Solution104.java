package com.example.leetcode.solution;

import java.util.Stack;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-27 10:22
 */
public class Solution104 {


    public static class Pair {
        TreeNode node;
        int height;

        public Pair(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }



    public static int myDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Stack<Pair> stack = new Stack<>();
        //首先压入root
        stack.push(new Pair(root, 1));
        while (!stack.empty()) {
            Pair pair = stack.pop();
            depth = Math.max(depth, pair.height);
            if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right, pair.height + 1));
            }
            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left, pair.height + 1));
            }
        }

        return depth;
    }


    //dfs 使用stack 压入下一个点
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode pop = pair.node;
            depth = depth > pair.height ? depth : pair.height;
            if (pop.right != null) {
                stack.add(new Pair(pop.right, pair.height + 1)); //right先一步进入栈中
            }
            if (pop.left != null) {
                stack.add(new Pair(pop.left, pair.height + 1));
            }
        }
        return depth;
    }


    int max = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth2(root.left);
            int right_height = maxDepth2(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        return maxTD(root, 0);
    }

    private int maxTD(TreeNode treeNode, int deep) {
        if (treeNode == null) return Math.max(max, deep);

        int d1 = maxTD(treeNode.left, deep + 1);
        int d2 = maxTD(treeNode.right, deep + 1);

        return Math.max(d1, d2);
    }
}
