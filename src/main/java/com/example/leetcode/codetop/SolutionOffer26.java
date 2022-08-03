package com.example.leetcode.codetop;

import java.util.*;

public class SolutionOffer26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode last;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // A的左右子树也能跟B递归
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private Boolean dfs(TreeNode a, TreeNode b) {
        // 什么时候返回true,停止递归
        if (b == null )
            return true;
        // 什么时候false,停止递归
        if (a == null || a.val != b.val) {
            return false;
        }
        // 一样时继续递归
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }

    public ArrayList<Integer> getTreeVal(TreeNode A) {
        ArrayList<Integer> arrayListA = new ArrayList();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        arrayListA.add(A.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.pollFirst();
                if (treeNode == null && queue.isEmpty()) {
                    continue;
                }
                if (treeNode == null) {
                    arrayListA.add(null);
                    continue;
                }

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    arrayListA.add(treeNode.left.val);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    arrayListA.add(treeNode.right.val);
                }
            }
        }
        return arrayListA;
    }

}
